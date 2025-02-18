package com.claire.NeoWs.Nasa.API.repository;

import com.claire.NeoWs.Nasa.API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    User findByClaimToken(String token);
}
