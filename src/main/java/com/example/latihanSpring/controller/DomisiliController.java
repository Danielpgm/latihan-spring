package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.DomisiliDto;
import com.example.latihanSpring.model.entity.DomisiliEntity;
import com.example.latihanSpring.model.entity.UserEntity;
import com.example.latihanSpring.repository.DomisiliRepo;
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
public class DomisiliController {
    @Autowired
    private DomisiliRepo domisiliRepo;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/insert/domisili")
    public ResponseEntity<?> insertdomisili(@RequestBody DomisiliDto dto){
        DomisiliEntity domisiliEntity= new DomisiliEntity();

        domisiliEntity.setKelurahan(dto.getKelurahan());
        domisiliEntity.setKecamatan(dto.getKecamatan());
        domisiliEntity.setProvinsi(dto.getProvinsi());
        domisiliRepo.save(domisiliEntity);

        UserEntity userEntity = userRepo.findByUsername(dto.getUsername()); // untuk mendapatkan username
        domisiliEntity.setUserEntity(userEntity);
        domisiliRepo.save(domisiliEntity);
        return ResponseEntity.ok(domisiliEntity);
    }

    @GetMapping("/domisili-all-data")
    public ResponseEntity<?> getAll(){
        List<DomisiliEntity> domisilis= domisiliRepo.findAll();
        return ResponseEntity.ok(domisilis);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updatedata(@PathVariable Integer id, @RequestBody DomisiliDto dto){
        DomisiliEntity domisiliEntity= domisiliRepo.findById(id).get();

        domisiliEntity.setKelurahan(dto.getKelurahan());
        domisiliEntity.setKecamatan(dto.getKecamatan());
        domisiliEntity.setProvinsi(dto.getProvinsi());
        domisiliRepo.save(domisiliEntity);

        UserEntity userEntity = userRepo.findByUsername(dto.getUsername()); // untuk mendapatkan username
        domisiliEntity.setUserEntity(userEntity);
        domisiliRepo.save(domisiliEntity);
        return ResponseEntity.ok(domisiliEntity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Integer id){
        DomisiliEntity domisiliEntity= domisiliRepo.findById(id).get();
        domisiliRepo.delete(domisiliEntity);
        return ResponseEntity.ok(domisiliEntity);
    }
}
