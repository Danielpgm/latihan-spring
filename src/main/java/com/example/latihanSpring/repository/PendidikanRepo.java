package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.Pendidikan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendidikanRepo extends JpaRepository<Pendidikan, Integer> {
    
}
