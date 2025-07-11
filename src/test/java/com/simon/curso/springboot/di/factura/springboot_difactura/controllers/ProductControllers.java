package com.simon.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllers {


    @GetMapping("/test")
    public String show() {
        return "prueba";
    }

}
