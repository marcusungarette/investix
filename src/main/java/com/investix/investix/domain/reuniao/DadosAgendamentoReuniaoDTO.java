package com.investix.investix.domain.reuniao;

import com.investix.investix.domain.assessor.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoReuniaoDTO(

        Long id,

        Long idAssessor,

        @NotNull
        Long idInvestidor,

        @NotNull
        @Future
        LocalDateTime data,   ///@JsonAlias({“data_da_consulta”, “data_consulta”}) LocalDateTime data
        ///@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        Boolean ativo,

        Especialidade especialidade
) {
}
