package com.investix.investix.domain.reuniao.validacoes;


import com.investix.investix.domain.assessor.AssessorRepository;
import com.investix.investix.domain.reuniao.DadosAgendamentoReuniaoDTO;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAssessorAtivo implements ValidadorAgendamentoDeReuniao {


    @Autowired
    private AssessorRepository repository;

    public void validar(DadosAgendamentoReuniaoDTO dados) {
        //escolha assessor opcional

        if(dados.idAssessor() == null) {
            return;
        }

        var assessorEstaAtivo = repository.findAtivoById(dados.idAssessor());
        if (!assessorEstaAtivo) {
            throw new ValidationException("Reuniao nao pode ser agendada com assessor inativo");
        }
    }
}
