package br.com.rinha.api.payloads;

import br.com.rinha.api.models.Transacoes;

import java.util.Objects;

public class TransacaoRequest {

    private Integer valor;

    private String tipo;

    private String descricao;

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Transacoes builder() {
        var t = new Transacoes();
        t.setValor(valor);
        t.setTipo(Objects.equals(tipo, "c"));
        t.setDescricao(descricao);
        return t;
    }
}
