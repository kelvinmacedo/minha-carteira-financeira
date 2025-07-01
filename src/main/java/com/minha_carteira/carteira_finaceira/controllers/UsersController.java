package com.minha_carteira.carteira_finaceira.controllers;

import com.minha_carteira.carteira_finaceira.dto.users.UserCreateDto;
import com.minha_carteira.carteira_finaceira.dto.users.UserDto;
import com.minha_carteira.carteira_finaceira.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> list = usersService.getAllUsers();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto user = usersService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }


    @PostMapping(value = "/create-user")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        UserDto createUser = usersService.createUser(userCreateDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createUser.getId()).toUri();
        return ResponseEntity.created(uri).body(createUser);
    }

    @PutMapping(value = "/update-user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        UserDto updatedUser = usersService.updateUser(id, userDto);
        return ResponseEntity.ok().body(updatedUser);
    }
}
