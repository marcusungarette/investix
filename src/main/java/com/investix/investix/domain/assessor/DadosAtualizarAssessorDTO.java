package com.investix.investix.domain.assessor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAssessorDTO(
        @NotNull
        Long id,
        String telefone,
        String nome
) {
}
