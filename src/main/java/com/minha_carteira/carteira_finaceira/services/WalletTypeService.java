package com.minha_carteira.carteira_finaceira.services;

import com.minha_carteira.carteira_finaceira.Repositories.UsersRepository;
import com.minha_carteira.carteira_finaceira.Repositories.WalletTypeRepository;
import com.minha_carteira.carteira_finaceira.dto.WalletTypeDto;
import com.minha_carteira.carteira_finaceira.entities.WalletTypeEntity;
import com.minha_carteira.carteira_finaceira.enums.WalletStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletTypeService {

    @Autowired
    private WalletTypeRepository walletTypeRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public List<WalletTypeDto> listAllWalletType() {
        List<WalletTypeEntity> list = walletTypeRepository.findAll();
        return list.stream().map(WalletTypeDto::new).collect(Collectors.toList());
    }

    public WalletTypeDto createWalletType(WalletTypeDto walletTypeDto) {
        WalletTypeEntity entity = new WalletTypeEntity();
        entity.setName(walletTypeDto.getName());
        entity.setStatus(WalletStatus.ATIVO);
        entity.setUser(usersRepository.findById(walletTypeDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User/Wallet not found")));
        entity = walletTypeRepository.save(entity);
        return new WalletTypeDto(entity);
    }
}
