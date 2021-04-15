package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.PendidikaDto;
import com.example.latihanSpring.model.entity.Pendidikan;
import com.example.latihanSpring.model.entity.UserEntity;
import com.example.latihanSpring.repository.PendidikanRepo;
import com.example.latihanSpring.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class PendidikanController {
    @Autowired
    private PendidikanRepo pendidikanRepo;  
    @Autowired
    private UserRepo userRepo;
    
    @PostMapping("/insert/pendidikan")
    public ResponseEntity<?> insertpendidikan(@RequestBody PendidikaDto dto){
        Pendidikan pendidikan=new Pendidikan();

        pendidikan.setInstitusi(dto.getInstitusi());
        pendidikan.setJenjang(dto.getJenjang());
        pendidikan.setKodependidikan(dto.getKodependidikan());
        pendidikanRepo.save(pendidikan);
        pendidikan.setKodependidikan("P" + pendidikan.getId());

        UserEntity userEntity= userRepo.findByUsername(dto.getUsername()); // untuk mendapatkan username yang berada di user entity
        pendidikan.setUserEntity(userEntity);
        pendidikanRepo.save(pendidikan);
        return ResponseEntity.ok(pendidikan);
    }
    
    @GetMapping("/pendidikan-all")
    public ResponseEntity<?> getAll(){
        List<Pendidikan> pendidikans= pendidikanRepo.findAll();
        return ResponseEntity.ok(pendidikans);  
    }

    @PutMapping("/update/pendidikan/{id}")
    public ResponseEntity<?> updateData(@PathVariable Integer id, @RequestBody PendidikaDto dto){
        Pendidikan pendidikan= pendidikanRepo.findById(id).get();
        pendidikan.setInstitusi(dto.getInstitusi());
        pendidikan.setJenjang(dto.getJenjang());
        pendidikan.setKodependidikan(dto.getKodependidikan());
        pendidikanRepo.save(pendidikan);
        pendidikan.setKodependidikan("P" + pendidikan.getId());

        UserEntity userEntity= userRepo.findByUsername(dto.getUsername()); // untuk mendapatkan username yang berada di user entity
        pendidikan.setUserEntity(userEntity);
        pendidikanRepo.save(pendidikan);
        return ResponseEntity.ok(pendidikan);
    }

    @DeleteMapping("/delete/pendidikan/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Integer id){
        Pendidikan pendidikan= pendidikanRepo.findById(id).get();

        pendidikanRepo.delete(pendidikan);
        return ResponseEntity.ok(pendidikan);
    }
}
