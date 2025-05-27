package com.minha_carteira.carteira_finaceira.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "wallet_type")
public class WalletTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UsersEntity user;
    private String Name;
    private String status;

    public WalletTypeEntity() {
    }

    public WalletTypeEntity(Long id, UsersEntity user, String name, String status) {
        this.id = id;
        this.user = user;
        this.Name = name;
        this.status = status;
    }
}
