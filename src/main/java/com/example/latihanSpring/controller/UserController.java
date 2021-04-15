package com.example.latihanSpring.controller;

import javax.imageio.spi.ServiceRegistry;
import javax.naming.spi.DirStateFactory.Result;

import com.example.latihanSpring.model.dto.LoginDto;
import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.dto.StatusMessageDto;
import com.example.latihanSpring.model.entity.DetailUserEntity;
import com.example.latihanSpring.model.entity.UserEntity;
import com.example.latihanSpring.repository.DetailUserRepo;
import com.example.latihanSpring.repository.UserRepo;
import com.example.latihanSpring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DetailUserRepo detailUserRepo;
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> regis(@RequestBody PersonDto dto){
        StatusMessageDto<UserEntity> result= new StatusMessageDto<>();
        try{
        // SEBELUM MENGGUNAKAN SERVICE
            // UserEntity userEntity= new UserEntity();
            // DetailUserEntity detailUserEntity= new DetailUserEntity();
            
            // userEntity.setUsername(dto.getUsername());
            // userEntity.setPassword(dto.getPassword());
            // userRepo.save(userEntity);
            
            // detailUserEntity.setNik(dto.getNik());
            // detailUserEntity.setFirstname(dto.getFirstname());
            // detailUserEntity.setLastname(dto.getLastname());
            // detailUserEntity.setDomisili(dto.getDomisili());
            // detailUserEntity.setGolDarah(dto.getGoldarah());
            // detailUserEntity.setTanggal(dto.getTanggal());
            // detailUserEntity.setUserEntity(userEntity);
            // detailUserRepo.save(detailUserEntity);
            
            // result.setStatus(HttpStatus.OK.value());
            // result.setMessage("Data berhasil tersimpan");
            // result.setData(userEntity);
            
            return userService.regisUser(dto);
        }catch(Exception e){
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto){
        return null;
    }
}
