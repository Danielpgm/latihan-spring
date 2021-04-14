package com.example.latihanSpring.controller;

import com.example.latihanSpring.model.dto.PendidikanDto;
import com.example.latihanSpring.model.entity.PendidikanEntity;
import com.example.latihanSpring.model.entity.UserEntity;
import com.example.latihanSpring.repository.PendidikanRepo;
import com.example.latihanSpring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class PendidikanController {
    @Autowired
    private PendidikanRepo pendidikanRepo;

    @PostMapping("/insert/pendidikan")
    public ResponseEntity<?> insertPendidikan(@RequestBody PendidikanDto dto){
        PendidikanEntity pendidikanEntity= new PendidikanEntity();

        pendidikanEntity.setInstitusi(dto.getInstitusi());
        pendidikanEntity.setJenjang(dto.getJenjang());
        pendidikanEntity.setKodePendidikan("P" + dto.getKodePendidikan());
        pendidikanRepo.save(pendidikanEntity);

        return null;
    }
}
