package com.rinha.rinhaspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;
import com.rinha.rinhaspring.models.*;
import com.rinha.rinhaspring.repository.*;
@Component
public class dinsertrinha implements CommandLineRunner {

    private final saldoRepository saldoRepository;
    private final transacaoRepository transacaoRepository;

    public dinsertrinha(saldoRepository saldoRepository, transacaoRepository transacaoRepository) {
        this.saldoRepository = saldoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Override
    public void run(String... args) {
        Saldo saldo1 = new Saldo();
        saldo1.setTotal(1000);
        saldo1.setData_extrato(new Date());
        saldoRepository.save(saldo1);

        Saldo saldo2 = new Saldo();
        saldo2.setTotal(2000);
        saldo2.setData_extrato(new Date());
        saldoRepository.save(saldo2);

        Transacao transacao1 = new Transacao();
        transacao1.setValor(100);
        transacao1.setTipo('d');
        transacao1.setDescricao("Debido");
        transacao1.setRealizada_em(new Date());
        transacao1.setSaldo(saldo1);
        transacaoRepository.save(transacao1);

        Transacao transacao2 = new Transacao();
        transacao2.setValor(50);
        transacao2.setTipo('c');
        transacao2.setDescricao("Credito");
        transacao2.setRealizada_em(new Date());
        transacao2.setSaldo(saldo1);
        transacaoRepository.save(transacao2);

        Transacao transacao3 = new Transacao();
        transacao3.setValor(200);
        transacao3.setTipo('d');
        transacao3.setDescricao("Debido");
        transacao3.setRealizada_em(new Date());
        transacao3.setSaldo(saldo2);
        transacaoRepository.save(transacao3);

        Transacao transacao4 = new Transacao();
        transacao4.setValor(-50);
        transacao4.setTipo('d');
        transacao4.setDescricao("Conta");
        transacao4.setRealizada_em(new Date());
        transacao4.setSaldo(saldo2);
        transacaoRepository.save(transacao4);
    }
}
