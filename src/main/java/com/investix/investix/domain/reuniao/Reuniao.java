package com.investix.investix.domain.reuniao;


import com.investix.investix.domain.assessor.Assessor;
import com.investix.investix.domain.investidor.Investidor;
import com.investix.investix.domain.reuniao.cancelamento.DadosCancelamentoReuniaoDTO;
import com.investix.investix.domain.reuniao.cancelamento.MotivoCancelamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "reunioes")
@Entity(name = "Reuniao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reuniao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessor_id")
    private Assessor assessor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investidor_id")
    private Investidor investidor;

    private LocalDateTime data;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivo;

    @Override
    public String toString() {
        return "Reuniao{" +
                "  id=" + id +
                ", assessor=" + assessor +
                ", investidor=" + investidor +
                ", data=" + data +
                ", ativo=" + ativo +
                ", motivo=" + motivo +
                '}';
    }

    public void atualizarInformacoes(DadosCancelamentoReuniaoDTO dados) {
        this.ativo = false;
        this.motivo = (dados.motivo() != null) ? dados.motivo() : this.motivo;
    }
}

