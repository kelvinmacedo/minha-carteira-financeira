package com.minha_carteira.carteira_finaceira.controllers;

import com.minha_carteira.carteira_finaceira.dto.WalletTypeDto;
import com.minha_carteira.carteira_finaceira.services.WalletTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet-type")
public class WalletTypeController {

    @Autowired
    private WalletTypeService walletTypeService;

    @GetMapping
    public ResponseEntity<List<WalletTypeDto>> listAllWallet(){
        List<WalletTypeDto> list = walletTypeService.listAllWalletType();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/create-wallet")
    public ResponseEntity<WalletTypeDto> createWalletType(@Valid @RequestBody WalletTypeDto walletTypeDto){
        WalletTypeDto createdWalletType = walletTypeService.createWalletType(walletTypeDto);
        return ResponseEntity.ok().body(createdWalletType);
    }


}
