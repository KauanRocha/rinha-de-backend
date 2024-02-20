package br.com.rinha.api.payloads;

import br.com.rinha.api.models.Transacoes;

import java.time.LocalDateTime;
import java.util.List;

public record ExtratoResponse(Saldo saldo, List<Transacao> ultimasTransacoes) {
    public ExtratoResponse(List<Transacoes> transacoes) {
        this(new Saldo(transacoes.get(0)), transacoes.stream().map(Transacao::new).toList());
    }
}

record Saldo(int total, LocalDateTime dataExtrato, int limite) {
    public Saldo(Transacoes transacao) {
        this(transacao.getSaldo(), LocalDateTime.now(), transacao.getLimite());

    }
}
 record Transacao(int valor, char tipo, String descricao, LocalDateTime realizadaEm) {
     public Transacao(br.com.rinha.api.models.Transacoes transacao) {
         this(transacao.getValor(), transacao.isTipo() ? 'c' : 'd', transacao.getDescricao(), transacao.getRealizadaEm());
     }
 }
