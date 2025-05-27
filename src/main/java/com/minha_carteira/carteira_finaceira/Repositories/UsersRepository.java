package com.minha_carteira.carteira_finaceira.Repositories;

import com.minha_carteira.carteira_finaceira.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersEntity,Long> {

    Optional<UsersEntity> findByEmail(String email);

}
