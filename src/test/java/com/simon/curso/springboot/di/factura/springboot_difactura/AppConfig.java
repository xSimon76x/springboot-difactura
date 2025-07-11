package com.simon.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.simon.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.simon.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties", encoding="UTF-8")
public class AppConfig {

    // Esta es una manera en la que uno puede definir un metodo que retorna un tipo de dato.
    // Y luego en alguna clase, uno puede definir un atributo para esa clase para importar el valor que retorna el metodo definido
    // Solo puede haber un metodo que retorne ese tipo de dato, si hay mas se debe usar el @Primary o definir un nombre distinto en el Bean
    // para usar el @Qualifier en el atributo de la clase, para saber cual metodo de aca se usara
    // (Se importa como se hizo en la clase Invoice)
    @Bean("itemsInvoiceDefault")
    List<Item> itemsInvoice() {
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Bicicleta Bianchi 26", 1200);
        return Arrays.asList(new Item(p1, 2), new Item(p2, 4));
    }

    @Bean
    @Primary
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor Asus 24", 800);
        Product p2 = new Product("Notebook Razer", 1200);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 1200);
        return Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));
    }

    @Bean
    String description1() {
        return "Factura Oficina 1";
    }

    @Bean
    String description2() {
        return "Factura Oficina 2";
    }
}
