package br.com.rinha.api.payloads;

import br.com.rinha.api.models.Transacoes;

public class TransacoesResponse {

    private final Transacoes transacoes;

    public TransacoesResponse(Transacoes transacoes) {
        this.transacoes = transacoes;
    }

    public Integer getLimite() {
        return transacoes.getLimite();
    }

    public Integer getSaldo() {
        return transacoes.getSaldo();
    }

}
