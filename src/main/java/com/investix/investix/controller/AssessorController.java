package com.investix.investix.controller;

import com.investix.investix.domain.assessor.Assessor;
import com.investix.investix.domain.assessor.AssessorRepository;
import com.investix.investix.domain.assessor.DadosCadastroAssessorDTO;
import com.investix.investix.domain.assessor.DadosDetalhamentoAssessorDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("assessores")
public class AssessorController {

    @Autowired // Dependency Injection
    private AssessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAssessorDTO dados, UriComponentsBuilder uriBuilder) {
        var assessor = new Assessor(dados);
        repository.save(assessor);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(assessor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAssessorDTO(assessor));
    }
}
