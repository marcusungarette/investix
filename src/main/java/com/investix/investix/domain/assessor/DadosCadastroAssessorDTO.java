package com.investix.investix.domain.assessor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAssessorDTO(
        @NotBlank(message = "Nome é obrigatório") //only for Strings
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @NotBlank(message = "AAI(ANCORD) é obrigatório")
        @Pattern(regexp = "\\d{5,6}", message = "Formato do AAI(ANCORD) é inválido") // Between 5 and 6 digits
        String aaiRegister,

        @NotNull(message = "Especialidade é obrigatória")
        Especialidade especialidade)
      {
}
