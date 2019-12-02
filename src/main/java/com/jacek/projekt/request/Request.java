package com.jacek.projekt.request;

import com.jacek.projekt.product.Product;
import com.jacek.projekt.store.Store;
import com.jacek.projekt.user.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

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

    @Column(name = "finished")
    private int finished;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "request_store", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "store_id"))
    private Set<Store> stores;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "request_product", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

}
