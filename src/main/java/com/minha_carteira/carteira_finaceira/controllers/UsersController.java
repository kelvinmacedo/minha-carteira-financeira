package com.minha_carteira.carteira_finaceira.controllers;

import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import com.minha_carteira.carteira_finaceira.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;



    @GetMapping
    public List<UsersEntity> findAll(){
        return usersService.findAll();
    }
}
