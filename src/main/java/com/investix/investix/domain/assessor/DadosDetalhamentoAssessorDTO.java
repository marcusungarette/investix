package com.investix.investix.domain.assessor;

public record DadosDetalhamentoAssessorDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        String aaiRegister,
        Enum Especialidade
) {
    public DadosDetalhamentoAssessorDTO(Assessor assessor) {
        this(assessor.getId(), assessor.getNome(), assessor.getEmail(), assessor.getTelefone(), assessor.getAaiRegister(), assessor.getEspecialidade());
    }
}
