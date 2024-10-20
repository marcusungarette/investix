package com.investix.investix.controller;


import com.investix.investix.domain.reuniao.AgendaReuniaoService;
import com.investix.investix.domain.reuniao.DadosAgendamentoReuniaoDTO;
import com.investix.investix.domain.reuniao.cancelamento.DadosCancelamentoReuniaoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reunioes")
public class ReuniaoController {

    @Autowired
    private AgendaReuniaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoReuniaoDTO dados){
        var dtoDevolvidoPelaService = service.agendar(dados);
        return ResponseEntity.ok(dtoDevolvidoPelaService);
    }

    @PutMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoReuniaoDTO dados){
        var dtoCancelarConsultaPelaService = service.cancelar(dados);
        return ResponseEntity.ok(dtoCancelarConsultaPelaService);
    }
}
