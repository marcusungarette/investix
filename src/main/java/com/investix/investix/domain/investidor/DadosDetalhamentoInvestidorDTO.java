package com.investix.investix.domain.investidor;

public record DadosDetalhamentoInvestidorDTO(
        Long id,
        String nome,
        String email,
        String telefone) {

    public DadosDetalhamentoInvestidorDTO(Investidor investidor) {
        this(investidor.getId(), investidor.getNome(), investidor.getEmail(), investidor.getCpf());
    }
}



