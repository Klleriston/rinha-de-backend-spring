package com.rinha.rinhaspring.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name ="saldo")
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int total;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_extrato;
    @OneToMany(mappedBy = "saldo", cascade = CascadeType.ALL)
    public List<Transacao> ultimas_transacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getData_extrato() {
        return data_extrato;
    }

    public void setData_extrato(Date data_extrato) {
        this.data_extrato = data_extrato;
    }

    public List<Transacao> getUltimas_transacoes() {
        return ultimas_transacoes;
    }

    public void setUltimas_transacoes(List<Transacao> ultimas_transacoes) {
        this.ultimas_transacoes = ultimas_transacoes;
    }
}
