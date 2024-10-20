package com.investix.investix.domain.assessor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface AssessorRepository extends JpaRepository<Assessor, Long> {
    Page<Assessor> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT a FROM Assessor a
            WHERE
            a.ativo = true
            AND
            a.especialidade = :especialidade
            AND a.id NOT IN(
                SELECT r.assessor.id
                FROM Reuniao r
                WHERE
                r.data = :data
            )
            ORDER BY FUNCTION('RAND')
            LIMIT 1
            """)
    Assessor escolherAssessorAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);


    @Query("""
            SELECT a.ativo
            FROM Assessor a
            WHERE
            a.id = :id
            """)
    Boolean findAtivoById(Long id);
}