package com.minha_carteira.carteira_finaceira.Repositories;

import com.minha_carteira.carteira_finaceira.entities.FinancialEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FinancialRepository extends JpaRepository<FinancialEntity, Long> {

}
