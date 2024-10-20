package com.investix.investix.domain.assessor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "Assessor")
@Table(name = "assessores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Assessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String aaiRegister;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private Boolean ativo;

    public Assessor(DadosCadastroAssessorDTO dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.aaiRegister = dados.aaiRegister();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
    }

    public void atualizarInformacoes(DadosAtualizarAssessorDTO dados) {
        this.nome = (dados.nome() != null) ? dados.nome() : this.nome;
        this.telefone = (dados.telefone() != null) ? dados.telefone() : this.telefone;
    }

    public void inativar() {
        this.ativo = false;
    }
}