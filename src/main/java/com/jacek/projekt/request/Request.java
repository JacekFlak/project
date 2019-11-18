package com.jacek.projekt.request;

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

    /*@Column(name = "store_id")
    @NotNull
    private String email;

    @Column(name = "product_id")
    @NotNull
    private String product_id;*/
    //tutaj wstawic relacje  jak te

    /*  @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;*/


    @Column(name = "quantity")
    @NotNull
    private int quantity;

    @Column(name = "description")
    @NotNull
    private String description;

}
