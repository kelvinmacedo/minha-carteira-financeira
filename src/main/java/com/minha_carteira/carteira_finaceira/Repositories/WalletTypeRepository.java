package com.minha_carteira.carteira_finaceira.Repositories;

import com.minha_carteira.carteira_finaceira.entities.WalletTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletTypeEntity, Long> {

}
