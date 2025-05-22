package com.minha_carteira.carteira_finaceira.dto;

import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class UsersDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;

    public UsersDto(){
    }

    public UsersDto(Long id, String fistName, String lastName, String email) {
        this.id = id;
        this.name = fistName;
        this.email = email;
    }

    public UsersDto(UsersEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
