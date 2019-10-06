package com.jacek.demoprojekt.modal;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;

    public User(String username, String firstname, String lastname, String password) {
    }

}
