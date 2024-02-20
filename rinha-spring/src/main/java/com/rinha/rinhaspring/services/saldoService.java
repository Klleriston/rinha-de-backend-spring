package com.rinha.rinhaspring.services;

import com.rinha.rinhaspring.models.Saldo;
import com.rinha.rinhaspring.repository.saldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class saldoService {
    private final saldoRepository saldoRepository;

    @Autowired
    public saldoService(saldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }

    public Saldo getSaldo(@PathVariable int id){
        return saldoRepository.findById(id).orElse(null);
    }

    public Saldo createSaldo(Saldo saldo) {
        return saldoRepository.save(saldo);
    }
}
