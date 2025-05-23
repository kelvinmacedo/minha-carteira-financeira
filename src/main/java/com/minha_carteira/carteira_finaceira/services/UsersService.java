package com.minha_carteira.carteira_finaceira.services;

import com.minha_carteira.carteira_finaceira.Repositories.UsersRepository;
import com.minha_carteira.carteira_finaceira.dto.users.UserCreateDto;
import com.minha_carteira.carteira_finaceira.dto.users.UserDto;
import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import com.minha_carteira.carteira_finaceira.mappers.UserMapper;
import com.minha_carteira.carteira_finaceira.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers(){
        return usersRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDto getUserById(Long id) {
        Optional<UsersEntity> obj = usersRepository.findById(id);
        UsersEntity entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
        return UserMapper.toDto(entity);
    }

    public UserDto createUser(UserCreateDto userDto) {
        UsersEntity user = UserMapper.createDto(userDto);
        return UserMapper.toDto(usersRepository.save(user));
    }


}
