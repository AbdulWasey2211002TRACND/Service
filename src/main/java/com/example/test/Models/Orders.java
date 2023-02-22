package com.example.test.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Orders")
@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    // columns
    private Long id;

    String name;
    Long price;
    Long totalprice;
    Long quantity;
    Long productid;

    // constructor
   

    public Orders() {

    }

    public Orders(Long id, String name, Long price, Long totalprice, Long quantity, Long productid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalprice = totalprice;
        this.quantity = quantity;
        this.productid = productid;
    }

}
