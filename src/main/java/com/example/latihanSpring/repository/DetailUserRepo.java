package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.DetailUserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailUserRepo extends JpaRepository<DetailUserEntity, Integer>{
    
}
