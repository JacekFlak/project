package com.jacek.projekt.store;

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
@Setter
@Getter
@NoArgsConstructor
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "street")
    @NotNull
    private String street;

    @Column(name = "number")
    @NotNull
    private String number;

    @Column(name = "country")
    @NotNull
    private String country;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "phone")
    @NotNull
    private int phone;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Set<Request> request;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id &&
                phone == store.phone &&
                Objects.equals(name, store.name) &&
                Objects.equals(city, store.city) &&
                Objects.equals(street, store.street) &&
                Objects.equals(number, store.number) &&
                Objects.equals(country, store.country) &&
                Objects.equals(email, store.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, street, number, country, email, phone);
    }
}
