package com.minha_carteira.carteira_finaceira.entities;

import com.minha_carteira.carteira_finaceira.enums.FinancialType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter @Setter
@Table(name = "financial")
public class FinancialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UsersEntity user;

    @Size(min = 3, max = 50, message = "A decrição deve possuir no minimo 3 e nomaximo 50 caracteres")
    @NotBlank(message = "Descrição é obrigatoria")
    private String description;

    @NotNull(message = "Valor é obrigatorio")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior ou igual a zero")
    private Double money;

    @NotNull(message = "Tipo financeiro é obrigatorio")
    @Enumerated(EnumType.STRING)
    private FinancialType financial_Type;


    @NotBlank(message = "Tipo de carteira é obrigatorio")
    private String wallet_Type;

    @CreationTimestamp
    @Column(updatable = false)
    private String created_Date;

    @UpdateTimestamp
    private String updated_Date;

    public FinancialEntity() {
    }

    public FinancialEntity(Long id, UsersEntity user, String description, Double money, FinancialType financial_Type, String wallet_Type) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.money = money;
        this.financial_Type = financial_Type;
        this.wallet_Type = wallet_Type;
    }
}
