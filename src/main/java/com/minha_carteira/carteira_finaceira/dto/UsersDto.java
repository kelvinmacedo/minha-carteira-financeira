package com.minha_carteira.carteira_finaceira.dto;

import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UsersDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String password;

    public UsersDto(){
    }

    public UsersDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public UsersDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UsersDto(UsersEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();


    }

}
