package com.jacek.projekt.product;

import com.jacek.projekt.request.Request;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    @NotNull
    private String name;

    @Column(name = "price_per_pack")
    @NotNull
    private float price_per_pack;

    @Column(name = "quantity_per_pack")
    @NotNull
    private int quantity_per_pack;

    @Column(name = "description")
    @NotNull
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Request> request;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Float.compare(product.price_per_pack, price_per_pack) == 0 &&
                quantity_per_pack == product.quantity_per_pack &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price_per_pack, quantity_per_pack, description);
    }
}