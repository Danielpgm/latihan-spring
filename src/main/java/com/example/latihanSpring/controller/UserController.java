package com.example.latihanSpring.controller;

import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.entity.DetailUserEntity;
import com.example.latihanSpring.model.entity.UserEntity;
import com.example.latihanSpring.repository.DetailUserRepo;
import com.example.latihanSpring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetailUserRepo detailUserRepo;

    @PostMapping("/registration")
    public ResponseEntity<?> userRegis(@RequestBody PersonDto dto){
    UserEntity userEntity= new UserEntity();
    DetailUserEntity detailUserEntity= new DetailUserEntity();
    
    userEntity.setPassword(dto.getPassword());
    userEntity.setUserName(dto.getUsername());
    userRepository.save(userEntity);

    detailUserEntity.setFirstname(dto.getFirstname());
    detailUserEntity.setLastname(dto.getLastname());
    detailUserEntity.setNik(dto.getNik());
    detailUserEntity.setTanggalLahir(dto.getTanggal());
    detailUserEntity.setUserEntity(userEntity);
    detailUserRepo.save(detailUserEntity);

    userRepository.save(userEntity);
        return ResponseEntity.ok("data telah disimpan");
    }
}