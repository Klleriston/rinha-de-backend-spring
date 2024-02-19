package com.rinha.rinhaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class saldoController {
    @GetMapping("/clientes")
    public String getSaldo() {
        return "sucess!";
    }
}
