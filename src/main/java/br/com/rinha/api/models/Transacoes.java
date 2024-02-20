package br.com.rinha.api.models;


import br.com.rinha.api.exceptions.UnprocessableEntityException;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Transient;


import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "valor", nullable = false)
    private Integer valor;

    @Column(name = "tipo", nullable = false)
    private boolean tipo;

    @Column(name = "descricao", nullable = false, length = 10)
    private String descricao;

    @CreatedDate
    @Column(name = "realizada_em")
    private LocalDateTime realizadaEm;

    @Column(name = "cliente_id")
    private Integer clienteId;

    @Column(name = "saldo")
    private Integer saldo;

    @Column(name = "limite")
    private Integer limite;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getRealizadaEm() {
        return realizadaEm;
    }

    public void setRealizadaEm(LocalDateTime realizadaEm) {
        this.realizadaEm = realizadaEm;
    }
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }


    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Transient
    public void calculateSaldo() {
        if(tipo) {
            this.saldo += valor;
            return;
        }
        if (saldo - valor <  this.limite*-1) {
            throw new UnprocessableEntityException();
        }
        this.saldo -= valor;
    }
}
