package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
}
