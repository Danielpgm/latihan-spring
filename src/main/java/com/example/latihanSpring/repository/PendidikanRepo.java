package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.PendidikanEntity;
import com.example.latihanSpring.model.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PendidikanRepo extends JpaRepository<PendidikanEntity, Integer> {
    public UserEntity findBUserEntity(String username);
}
