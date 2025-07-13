package com.simon.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;

    // @Value("${invoice.description.office}")
    @Autowired
    @Qualifier("description1")
    private String description;
    
    @Autowired
    private List<Item> items;

    public Invoice() {
        System.out.println("Creando el componente de la factura.");
        System.out.println(client); 
    }
    
    @PostConstruct
    public void init() {
        //Esto siempre se auto-ejecutara luego de haber creado o instanciado el componente, luego de la ejecucion del constructor
        System.out.println("Luego de haber creado el componente de la factura.");
        client.setName(client.getName().concat(" Pepe"));
        System.out.println(client); 
    }

    @PreDestroy
    public void destroy() {
        //Esto se auto-ejecutara cuando se destruya el componente
        System.out.println("Al destruir el componente");
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        // int total = 0;

        // for (Item item : items) {
        //     total += item.getImporte();
        // }
        return items.stream()
        .map( item -> item.getImporte())
        .reduce(0, (sum, importe) -> sum + importe);
    }
}
