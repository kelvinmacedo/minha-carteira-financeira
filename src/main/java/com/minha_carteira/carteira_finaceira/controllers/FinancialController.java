package com.minha_carteira.carteira_finaceira.controllers;

import com.minha_carteira.carteira_finaceira.dto.FinancialDto;
import com.minha_carteira.carteira_finaceira.services.FinancialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financial")
public class FinancialController {

    @Autowired
    private FinancialService financialService;

    @GetMapping
    public ResponseEntity<List<FinancialDto>> listFinancial(){
        List<FinancialDto> financialList = financialService.listFinancial();
        return ResponseEntity.ok().body(financialList);
    }

    @PostMapping("/create-financial")
    public ResponseEntity<FinancialDto> createFinancial(@Valid @RequestBody FinancialDto financialDto) {
        FinancialDto createdFinancial = financialService.createFinancial(financialDto);
        return ResponseEntity.ok().body(createdFinancial);
    }
}
