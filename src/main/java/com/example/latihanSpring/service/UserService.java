package com.example.latihanSpring.service;

import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.dto.StatusMessageDto;
import com.example.latihanSpring.model.entity.UserEntity;

import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> regisUser(PersonDto dto);
}
