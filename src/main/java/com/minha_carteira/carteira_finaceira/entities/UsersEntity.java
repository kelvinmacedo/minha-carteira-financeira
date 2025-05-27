package com.minha_carteira.carteira_finaceira.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UsersEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    public UsersEntity() {
        
    }

    public UsersEntity(Long id, String fistName, String lastName, String email, String password) {
        this.id = id;
        this.name = fistName;
        this.email = email;
        this.password = password;
    }
}
