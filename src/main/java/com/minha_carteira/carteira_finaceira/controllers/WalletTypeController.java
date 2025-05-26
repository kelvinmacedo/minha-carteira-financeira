package com.minha_carteira.carteira_finaceira.controllers;

import com.minha_carteira.carteira_finaceira.dto.WalletTypeDto;
import com.minha_carteira.carteira_finaceira.services.WalletTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallet-type")
public class WalletTypeController {

    @Autowired
    private WalletTypeService walletTypeService;

    @GetMapping
    public ResponseEntity<List<WalletTypeDto>> findAll(){
        List<WalletTypeDto> list = walletTypeService.findAllWalletType();
        return ResponseEntity.ok().body(list);
    }
}
