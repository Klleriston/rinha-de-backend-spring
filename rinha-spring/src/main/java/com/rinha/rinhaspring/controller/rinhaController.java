package com.rinha.rinhaspring.controller;

import com.rinha.rinhaspring.models.Transacao;
import jakarta.validation.ValidationException;
import org.springframework.web.bind.annotation.*;
import com.rinha.rinhaspring.repository.*;
import com.rinha.rinhaspring.models.Saldo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class rinhaController {
    private final saldoRepository saldoRepository;
    private final transacaoRepository transacaoRepository;

    public rinhaController(saldoRepository saldoRepository, transacaoRepository transacaoRepository) {
        this.saldoRepository = saldoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/clientes/{id}/extrato")
    public ResponseEntity<?> getExtrato(@PathVariable int id) {
        Saldo saldo = saldoRepository.findById(id).orElse(null);
        if (saldo == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(saldo);
        }
    }

    @PostMapping("/clientes/{id}/transacoes")
    public ResponseEntity<?> postTransacao(@PathVariable int id, @RequestBody Transacao transacao) {
        Saldo saldo = saldoRepository.findById(id).orElseThrow(() -> new clienteNotFoundException(id));

        try {
            if (transacao.getTipo() == 'd') {
                int novoTotal = saldo.getTotal() - transacao.getValor();
                saldo.setTotal(novoTotal);
            } else if (transacao.getTipo() == 'c') {
                int novoLimite = saldo.getLimite() - transacao.getValor();
                saldo.setLimite(novoLimite);
            }

            saldoRepository.save(saldo);
            Transacao savedTransacao = transacaoRepository.save(transacao);

            Saldo response = new Saldo();
            response.setLimite(saldo.getLimite());
            response.setTotal(saldo.getTotal());

            return ResponseEntity.ok(response);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de validação: " + e.getMessage());
        }
    }
}
