package com.minha_carteira.carteira_finaceira.controllers;

import com.minha_carteira.carteira_finaceira.dto.UsersDto;
import com.minha_carteira.carteira_finaceira.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsersDto> findById(@PathVariable Long id){
        UsersDto userDto= usersService.findById(id);
        return ResponseEntity.ok().body(userDto);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<UsersDto> insert(@RequestBody UsersDto usersDto) {
        usersDto = usersService.insert(usersDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(usersDto.getId()).toUri();
        return ResponseEntity.created(uri).body(usersDto);
    }
}
