package com.rinha.rinhaspring.controller;

public class clienteNotFoundException extends RuntimeException{

    clienteNotFoundException(int id) {
        super("Id not found" + id);
    }
}
