package com.minha_carteira.carteira_finaceira.services;

import com.minha_carteira.carteira_finaceira.Repositories.FinancialRepository;
import com.minha_carteira.carteira_finaceira.Repositories.UsersRepository;
import com.minha_carteira.carteira_finaceira.Repositories.WalletTypeRepository;
import com.minha_carteira.carteira_finaceira.dto.FinancialDto;
import com.minha_carteira.carteira_finaceira.entities.FinancialEntity;
import com.minha_carteira.carteira_finaceira.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinancialService {

    @Autowired
    public UsersRepository usersRepository;

    @Autowired
    public FinancialRepository financialRepository;

    @Transactional(readOnly = true)
    public List<FinancialDto> listFinancial() {
        List<FinancialEntity> financialEntity = financialRepository.findAll();
        return financialEntity.stream().map(FinancialDto::new).collect(Collectors.toList());
    }
    @Transactional
    public FinancialDto createFinancial(FinancialDto financialDto) {
        FinancialEntity financialEntity = new FinancialEntity();
        financialEntity.setDescription(financialDto.getDescription());
        financialEntity.setFinancial_Type(financialDto.getFinancialType());
        financialEntity.setMoney(financialDto.getMoney());
        financialEntity.setWallet_Type(financialDto.getWalletType());
        financialEntity.setUser(usersRepository.findById(financialDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User id em financial not found")));
        financialEntity = financialRepository.save(financialEntity);
        return new FinancialDto(financialEntity);
    }
}
