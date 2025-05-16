package com.minha_carteira.carteira_finaceira.services;

import com.minha_carteira.carteira_finaceira.Repositories.UsersRepository;
import com.minha_carteira.carteira_finaceira.dto.UsersDto;
import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional(readOnly = true) //-> Otimizar as operações de leitura.
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
}
