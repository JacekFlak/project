package com.jacek.demoprojekt.modal;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor //konstruktor bezparametrowy
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
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }
}
