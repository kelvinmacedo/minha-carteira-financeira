package com.minha_carteira.carteira_finaceira.dto;

import com.minha_carteira.carteira_finaceira.entities.WalletTypeEntity;
import com.minha_carteira.carteira_finaceira.enums.WalletStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class WalletTypeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String name;
    private WalletStatus status;

    public WalletTypeDto() {
    }

    public WalletTypeDto(Long id,String name, WalletStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public WalletTypeDto(WalletTypeEntity walletEntity) {
        this.id = walletEntity.getId();
        this.name = walletEntity.getName();
        this.status = walletEntity.getStatus();
        this.userId = walletEntity.getUser().getId();
    }
}
