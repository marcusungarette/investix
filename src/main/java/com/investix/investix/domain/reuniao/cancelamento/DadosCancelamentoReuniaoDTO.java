package com.investix.investix.domain.reuniao.cancelamento;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoReuniaoDTO(

        @NotNull
        Long id,

        MotivoCancelamento motivo
) {
}
