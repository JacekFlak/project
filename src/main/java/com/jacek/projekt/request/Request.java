package com.jacek.projekt.request;

import com.jacek.projekt.product.Product;
import com.jacek.projekt.store.Store;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "request")
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private int id;

    @Column(name = "quantity")
    @NotNull
    private int quantity;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "approved")
    private int approved;

    @ManyToOne(cascade = CascadeType.ALL)
    private Store store;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

}
