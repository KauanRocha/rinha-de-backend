package br.com.rinha.api.controllers;


import br.com.rinha.api.payloads.ExtratoResponse;
import br.com.rinha.api.payloads.TransacaoRequest;
import br.com.rinha.api.payloads.TransacoesResponse;
import br.com.rinha.api.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private final TransacoesService transacoesService;

    @Autowired
    ApiController (TransacoesService transacoesService) {
        this.transacoesService = transacoesService;
    }

    @PostMapping("/clientes/{id}/transacoes")
    public TransacoesResponse criaTransacao(@PathVariable(name = "id") Integer clienteId, @RequestBody TransacaoRequest transacaoRequest) {
        return new TransacoesResponse(transacoesService.criaTransacoes(clienteId, transacaoRequest));
    }

    @GetMapping("/clientes/{id}/extrato")
    public ExtratoResponse buscaExtrato(@PathVariable(name = "id") Integer clienteId) {
        return new ExtratoResponse(transacoesService.buscaExtrato(clienteId));
    }
}