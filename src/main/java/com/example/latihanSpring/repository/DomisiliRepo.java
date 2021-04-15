package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.DomisiliEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomisiliRepo extends JpaRepository<DomisiliEntity, Integer>{
    
}
