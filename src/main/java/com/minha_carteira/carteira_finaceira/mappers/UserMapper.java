package com.minha_carteira.carteira_finaceira.mappers;

import com.minha_carteira.carteira_finaceira.dto.users.UserCreateDto;
import com.minha_carteira.carteira_finaceira.dto.users.UserDto;
import com.minha_carteira.carteira_finaceira.entities.UsersEntity;

public class UserMapper {

    public static UserDto toDto(UsersEntity user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public static UsersEntity createDto(UserCreateDto createDto) {
        UsersEntity user = new UsersEntity();
        user.setName(createDto.getName());
        user.setEmail(createDto.getEmail());
        user.setPassword(createDto.getPassword());
        return user;
    }
}
