package com.investix.investix.domain.investidor;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Investidor")
@Table(name= "investidores")
public class Investidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Boolean ativo;

    public Investidor(DadosCadastroInvestidorDTO dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
    }

    public void atualizarInformacoes(DadosAtualizarInvestidorDTO dados) {
        this.nome = (dados.nome() != null) ? dados.nome() : this.nome;
        this.telefone = (dados.telefone() != null) ? dados.telefone() : this.telefone;
        }

    public void inativar() {
        this.ativo = false;
    }

}
