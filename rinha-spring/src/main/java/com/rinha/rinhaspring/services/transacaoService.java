package com.rinha.rinhaspring.services;

import com.rinha.rinhaspring.models.Saldo;
import com.rinha.rinhaspring.models.Transacao;
import com.rinha.rinhaspring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class transacaoService {

    private final saldoRepository saldoRepository;
    private final transacaoRepository transacaoRepository;

    @Autowired
    public transacaoService(saldoRepository saldoRepository, transacaoRepository transacaoRepository) {
        this.saldoRepository = saldoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    public Transacao makeTransaction(int id, Transacao transacao) {
        Saldo saldo = saldoRepository.findById(id).orElseThrow(() -> new RuntimeException("Saldo não encontrado para o ID fornecido: " + id));

        if (transacao.getTipo() == 'd') {
            int novoTotal = saldo.getTotal() - transacao.getValor();
            saldo.setTotal(novoTotal);
        } else if (transacao.getTipo() == 'c') {
            int novoLimite = saldo.getLimite() - transacao.getValor();
            saldo.setLimite(novoLimite);
        }

        saldoRepository.save(saldo);

        Transacao novaTransacao = transacaoRepository.save(transacao);
        return novaTransacao;
    }
}
