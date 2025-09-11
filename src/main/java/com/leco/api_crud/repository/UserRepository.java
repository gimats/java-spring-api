package com.leco.api_crud.repository;

import com.leco.api_crud.model.UserJwt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJwt, Long> {
    UserJwt findByUsername(String username);
}