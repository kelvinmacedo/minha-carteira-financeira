package com.minha_carteira.carteira_finaceira.dto;

import com.minha_carteira.carteira_finaceira.entities.WalletTypeEntity;

import java.io.Serializable;

public class WalletTypeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String status;

    public WalletTypeDto() {
    }

    public WalletTypeDto(Long id,String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public WalletTypeDto(WalletTypeEntity walletEntity) {
        this.id = walletEntity.getId();
        this.name = walletEntity.getName();
        this.status = walletEntity.getStatus();
    }
}
