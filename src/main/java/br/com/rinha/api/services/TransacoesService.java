package br.com.rinha.api.services;


import br.com.rinha.api.exceptions.NotFoundException;
import br.com.rinha.api.models.Transacoes;
import br.com.rinha.api.payloads.TransacaoRequest;
import br.com.rinha.api.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {

    public static int[] ids = {1, 2, 3, 4, 5};

    private final TransactionRepository transactionRepository;

    @Autowired
    TransacoesService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transacoes criaTransacoes(int clienteId, TransacaoRequest transacaoRequest) {
        var ultimaTransacao = transactionRepository.findFirstByClienteIdOrderByIdDesc(clienteId).orElseThrow(NotFoundException::new);
        var novaTransacao = transacaoRequest.builder();
        novaTransacao.setClienteId(ultimaTransacao.getClienteId());
        novaTransacao.setSaldo(ultimaTransacao.getSaldo());
        novaTransacao.setLimite(ultimaTransacao.getLimite());
        novaTransacao.calculateSaldo();
        return transactionRepository.save(novaTransacao);

    }

    public List<Transacoes> buscaExtrato(int clienteId) {
        List<Transacoes> ultimasTransacoes = transactionRepository.findFirst10ByClienteIdOrderByIdDesc(clienteId);
        if (ultimasTransacoes.isEmpty()) {
            throw new NotFoundException();
        }

        return ultimasTransacoes;
    }

}
