package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.ProvinsiDto;
import com.example.latihanSpring.service.ProvinsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/v1")
public class ProvinsiController {
    @Autowired
    private ProvinsiService provinsiService;

    @PostMapping("/insert/provinsi")
    public ResponseEntity<?> postprovinsi(@RequestBody List<ProvinsiDto> dto) {
        return provinsiService.inputprovinsi(dto);
    }

    @PutMapping("/update/provinsi/{id}")
    public ResponseEntity<?> putProvinsi(@PathVariable Integer id, @RequestBody ProvinsiDto dto){
        return provinsiService.updateProvinsi(id, dto);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        return provinsiService.getAll();
    }

    @GetMapping("/get/provinsi/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return provinsiService.getById(id);
    }

    @GetMapping("/get/bykodeprovinsi/{kode}")
    public ResponseEntity<?> getByKodeProvinsi(@PathVariable Integer kode){
        return provinsiService.getByKodeProvinsi(kode);
    }

    @DeleteMapping("/delete-{id}")
    public ResponseEntity <?> deletedata(@PathVariable Integer id){
        return provinsiService.deleteData(id);
    }
}
