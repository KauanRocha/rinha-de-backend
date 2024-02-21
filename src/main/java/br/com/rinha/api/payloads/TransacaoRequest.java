package br.com.rinha.api.payloads;

import br.com.rinha.api.models.Transacoes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

public class TransacaoRequest {

    @Min(value = 1)
    private Integer valor;

    @Pattern(regexp = "[cd]")
    private String tipo;

    @Size(max = 10)
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
