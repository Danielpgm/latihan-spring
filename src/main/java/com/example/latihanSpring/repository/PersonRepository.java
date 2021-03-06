package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.PersonEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    
}
