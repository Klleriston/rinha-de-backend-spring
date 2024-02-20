package com.rinha.rinhaspring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int valor;
    private char tipo;
    private String descricao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date realizada_em;

    @ManyToOne
    @JoinColumn(name = "saldo_id")
    @JsonIgnore
    private Saldo saldo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getRealizada_em() {
        return realizada_em;
    }

    public void setRealizada_em(Date realizada_em) {
        this.realizada_em = realizada_em;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }
}
