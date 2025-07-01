package com.minha_carteira.carteira_finaceira.entities;


import com.minha_carteira.carteira_finaceira.enums.WalletStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres")
    private String name;

    @Enumerated(EnumType.STRING)
    private WalletStatus status;

    public WalletTypeEntity() {
    }

    public WalletTypeEntity(Long id, UsersEntity user, String name,WalletStatus status) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.status = status;
    }
}
