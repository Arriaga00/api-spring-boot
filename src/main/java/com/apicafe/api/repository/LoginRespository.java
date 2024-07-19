package com.apicafe.api.repository;

import com.apicafe.api.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRespository extends JpaRepository<Login, Long> {
   public Login findByUsername(String username);
}