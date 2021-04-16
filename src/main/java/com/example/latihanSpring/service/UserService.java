package com.example.latihanSpring.service;
import java.util.List;

import com.example.latihanSpring.model.dto.DomisiliDto;
import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.entity.Pendidikan;

import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> regisUser(PersonDto dto);
}
