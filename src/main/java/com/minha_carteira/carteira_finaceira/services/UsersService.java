package com.minha_carteira.carteira_finaceira.services;

import com.minha_carteira.carteira_finaceira.Repositories.UsersRepository;
import com.minha_carteira.carteira_finaceira.dto.UsersDto;
import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import com.minha_carteira.carteira_finaceira.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public List<UsersDto> findAll(){
        List<UsersEntity> list = usersRepository.findAll();
        return list.stream().map(x -> new UsersDto(x)).collect(Collectors.toList());


//sem expressão lambda
//        List<UsersDto> listDto = new ArrayList<>();
//        for (UsersEntity user : list ){
//            listDto.add(new UsersDto(user));
//        }
//        return listDto;
    }
    @Transactional(readOnly = true)
    public UsersDto findById(Long id) {
        Optional<UsersEntity> obj = usersRepository.findById(id);
        UsersEntity entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UsersDto(entity);
    }

    @Transactional
    public UsersDto insert(UsersDto usersDto) {
        UsersEntity entity = new UsersEntity();
        entity.setName(usersDto.getName());
        entity.setEmail(usersDto.getEmail());
        entity.setPassword(usersDto.getPassword());
        entity = usersRepository.save(entity);
        UsersDto user = new UsersDto(entity.getId(), entity.getName(), usersDto.getEmail());
        user.setId(entity.getId());
        user.setEmail(entity.getEmail());
        user.setName(entity.getName());
        return user;
    }
}
