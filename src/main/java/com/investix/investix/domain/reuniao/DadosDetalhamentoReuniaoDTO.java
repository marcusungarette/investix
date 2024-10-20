package com.investix.investix.domain.reuniao;

import java.time.LocalDateTime;

public record DadosDetalhamentoReuniaoDTO(Long id, Long idInvestidor, Long idAssessor, LocalDateTime data) {
    public DadosDetalhamentoReuniaoDTO(Reuniao reuniao) {
        this(reuniao.getId(), reuniao.getInvestidor().getId(), reuniao.getAssessor().getId(), reuniao.getData());
    }
}
