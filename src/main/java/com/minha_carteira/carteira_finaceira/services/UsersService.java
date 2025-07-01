package com.minha_carteira.carteira_finaceira.services;

import com.minha_carteira.carteira_finaceira.Repositories.UsersRepository;
import com.minha_carteira.carteira_finaceira.dto.users.UserCreateDto;
import com.minha_carteira.carteira_finaceira.dto.users.UserDto;
import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import com.minha_carteira.carteira_finaceira.mappers.UserMapper;
import com.minha_carteira.carteira_finaceira.services.exceptions.ResourceAlreadyExistsException;
import com.minha_carteira.carteira_finaceira.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Transactional
    public UserDto createUser(UserCreateDto userDto) {
        usersRepository.findByEmail(userDto.getEmail()).ifPresent(existingUser -> {
            throw new ResourceAlreadyExistsException("E-mail já cadastrado! ");
        });
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UsersEntity user = UserMapper.createDto(userDto);
        return UserMapper.toDto(usersRepository.save(user));
    }

    @Transactional
    public UserDto updateUser(Long id, UserDto userDto) {
        UsersEntity userEntity = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        return UserMapper.toDto(usersRepository.save(userEntity));
    }
}
