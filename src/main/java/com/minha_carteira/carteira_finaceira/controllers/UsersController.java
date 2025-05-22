package com.minha_carteira.carteira_finaceira.controllers;

import com.minha_carteira.carteira_finaceira.dto.UsersDto;
import com.minha_carteira.carteira_finaceira.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UsersDto>> findAll(){
        List<UsersDto> list = usersService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
