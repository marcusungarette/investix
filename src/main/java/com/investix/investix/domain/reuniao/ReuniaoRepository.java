package com.investix.investix.domain.reuniao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReuniaoRepository extends JpaRepository<Reuniao, Long> {
    Boolean existsByAssessorIdAndData(Long idAssessor, LocalDateTime data);

    Boolean existsByInvestidorIdAndDataBetween(Long idInvestidor, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
