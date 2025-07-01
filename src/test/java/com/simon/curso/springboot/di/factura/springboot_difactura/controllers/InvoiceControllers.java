package com.simon.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.di.factura.springboot_difactura.models.Invoice;


@RestController
@RequestMapping("/invoices")
public class InvoiceControllers {

    @Autowired
    private Invoice invoice;
    
    @GetMapping("/show")
    public Invoice show() {
        return invoice;
    }

}
