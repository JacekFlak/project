package com.jacek.projekt.product;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int product_id;

    @Column(name = "product_name")
    @NotNull
    private String product_name;

    @Column(name = "price_per_pack")
    @NotNull
    private float price_per_pack;

    @Column(name = "quantity_per_pack")
    @NotNull
    private int quantity_per_pack;

  /*  @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))*/


}