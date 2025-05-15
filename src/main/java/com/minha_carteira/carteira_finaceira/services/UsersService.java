package com.minha_carteira.carteira_finaceira.services;

import com.minha_carteira.carteira_finaceira.Repositories.UsersRepository;
import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional(readOnly = true) //-> Otimizar as operações de leitura.
    public List<UsersEntity> findAll(){
        return usersRepository.findAll();
    }
}
