package com.investix.investix.domain.reuniao.cancelamento;

import com.investix.investix.domain.reuniao.Reuniao;

import java.time.LocalDateTime;

public record DadosDetalhamentoReuniaoCanceladaDTO(Long id, Long idInvestidor, Long idAssessor, LocalDateTime data, MotivoCancelamento motivo) {
    public DadosDetalhamentoReuniaoCanceladaDTO(Reuniao reuniao) {
        this(reuniao.getId(), reuniao.getInvestidor().getId(), reuniao.getAssessor().getId(), reuniao.getData(), reuniao.getMotivo());
    }
}
