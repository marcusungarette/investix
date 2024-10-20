package com.investix.investix.controller;


import com.investix.investix.domain.investidor.DadosCadastroInvestidorDTO;
import com.investix.investix.domain.investidor.DadosDetalhamentoInvestidorDTO;
import com.investix.investix.domain.investidor.Investidor;
import com.investix.investix.domain.investidor.InvestidorRepository;
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
@RequestMapping("investidores")
public class InvestidorController {

    @Autowired
    private InvestidorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroInvestidorDTO dados, UriComponentsBuilder uriBuilder) {
        var investidor = new Investidor(dados);
        repository.save(investidor);

        var uri = uriBuilder.path("/investidores/{id}").buildAndExpand(investidor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoInvestidorDTO(investidor));
    }
}
