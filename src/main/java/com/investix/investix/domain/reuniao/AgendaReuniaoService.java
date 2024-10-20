package com.investix.investix.domain.reuniao;


import com.investix.investix.domain.assessor.Assessor;
import com.investix.investix.domain.assessor.AssessorRepository;
import com.investix.investix.domain.investidor.Investidor;
import com.investix.investix.domain.investidor.InvestidorRepository;
import com.investix.investix.domain.reuniao.cancelamento.DadosCancelamentoReuniaoDTO;
import com.investix.investix.domain.reuniao.cancelamento.DadosDetalhamentoReuniaoCanceladaDTO;
import com.investix.investix.domain.reuniao.cancelamento.ValidadorCancelamentoDeReuniao;
import com.investix.investix.domain.reuniao.validacoes.ValidadorAgendamentoDeReuniao;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaReuniaoService {

    @Autowired
    private ReuniaoRepository reuniaoRepository;

    @Autowired
    private AssessorRepository assessorRepository;

    @Autowired
    private InvestidorRepository investidorRepository;

    @Autowired
    private List<ValidadorAgendamentoDeReuniao> validadores;

    @Autowired
    private List<ValidadorCancelamentoDeReuniao> validadoresCancelamento;

    public DadosDetalhamentoReuniaoDTO agendar(DadosAgendamentoReuniaoDTO dados) {

        if(!investidorRepository.existsById(dados.idInvestidor())) {
            throw new ValidationException("Id do Investidor informado nao existe!");
        }

        if (dados.idAssessor() != null && !assessorRepository.existsById(dados.idAssessor())) {
            throw new ValidationException("Id do Assessor informado nao existe!");
        }

        validadores.forEach(v -> v.validar(dados));

        Investidor investidor = investidorRepository.getReferenceById(dados.idInvestidor());
        Assessor assessor = escolherAssessor(dados);

        if (assessor == null) {
            throw new ValidationException("Nao existe assessor disponivel nessa data");
        }

        Reuniao reuniao = new Reuniao(dados.id(), assessor, investidor, dados.data(),(dados.ativo() != null ? dados.ativo() : true), null);
        reuniaoRepository.save(reuniao);

        return new DadosDetalhamentoReuniaoDTO(reuniao);
    }

    private Assessor escolherAssessor(DadosAgendamentoReuniaoDTO dados) {
        if (dados.idAssessor() != null){
            return assessorRepository.getReferenceById(dados.idAssessor());
        }

        if (dados.especialidade() == null){
            throw new ValidationException("Especialidade e obrigatoria quando assessor nao for escolhido");
        }

        return assessorRepository.escolherAssessorAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public DadosDetalhamentoReuniaoCanceladaDTO cancelar(DadosCancelamentoReuniaoDTO dados) {
        if (!reuniaoRepository.existsById(dados.id())) {
            throw new ValidationException("Id da reuniao informado não existe!");
        }
        validadoresCancelamento.forEach(v -> v.validar(dados));

        var reuniao = reuniaoRepository.getReferenceById(dados.id());
        reuniao.atualizarInformacoes(dados);
        return new DadosDetalhamentoReuniaoCanceladaDTO(reuniao);
    }
}
