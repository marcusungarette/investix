package com.investix.investix.domain.reuniao.cancelamento;


import com.investix.investix.domain.reuniao.ReuniaoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaParaCancelamento implements ValidadorCancelamentoDeReuniao{

    @Autowired
    private ReuniaoRepository repository;


    @Override
    public void validar(DadosCancelamentoReuniaoDTO dados) {
        var reuniao = repository.getReferenceById(dados.id());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, reuniao.getData()).toHours();

        if (diferencaEmHoras < 1) {
            throw new ValidationException("Reuniao somente pode ser cancelada com antecedência mínima de 1h!");
        }
    }
}
