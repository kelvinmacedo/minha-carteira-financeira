package com.minha_carteira.carteira_finaceira.dto;

import com.minha_carteira.carteira_finaceira.entities.FinancialEntity;
import com.minha_carteira.carteira_finaceira.enums.FinancialType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class FinancialDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String walletType;
    private String description;
    private Double money;
    private FinancialType financialType;
    private String createdDate;
    private String updatedDate;

    public FinancialDto () {
    }

    public FinancialDto (Long id, Long userId, String WalletType, String description, Double money, FinancialType financialType, String createdDate, String updatedDate) {
        this.id = id;
        this.userId = userId;
        this.walletType = WalletType;
        this.description = description;
        this.money = money;
        this.financialType = financialType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public FinancialDto (FinancialEntity financialEntity) {
        this.id = financialEntity.getId();
        this.userId = financialEntity.getUser().getId();
        this.walletType = financialEntity.getWallet_Type();
        this.description = financialEntity.getDescription();
        this.money = financialEntity.getMoney();
        this.financialType = financialEntity.getFinancial_Type();
        this.createdDate = financialEntity.getCreated_Date();
        this.updatedDate = financialEntity.getUpdated_Date();
    }

}
