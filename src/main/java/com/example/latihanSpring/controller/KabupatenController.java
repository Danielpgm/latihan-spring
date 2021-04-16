package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.KabupateDto;
import com.example.latihanSpring.model.entity.KabupatenEntity;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
import com.example.latihanSpring.repository.KabupatenRepo;
import com.example.latihanSpring.repository.ProvinsiRepo;
import com.example.latihanSpring.service.KabupatenService;

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
@RequestMapping ("/v1")
public class KabupatenController {
    @Autowired
    private KabupatenRepo kabupatenRepo;
    @Autowired
    private ProvinsiRepo provinsiRepo;
    @Autowired
    private KabupatenService kabupatenService;

    @PostMapping("/insert/kabupaten")
    public ResponseEntity<?> postprovinsi(@RequestBody List<KabupateDto> dto) {
        return kabupatenService.inputKabupaten(dto);
    }

    @PutMapping("/update/kabupaten/{id}")
    public ResponseEntity<?> putProvinsi(@PathVariable Integer id, @RequestBody KabupateDto dto){
        return kabupatenService.updateKabupaten(id, dto);
    }

    @GetMapping("/kabupaten/get/all")
    public ResponseEntity<?> getAll() {
        return kabupatenService.getAll();
    }

    @GetMapping("/kabupaten/get/byId/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return kabupatenService.getById(id);
    }

    @GetMapping("/kabupaten/get/bykodekab/{id}")
    public ResponseEntity<?> getByKodeKabupaten(@PathVariable Integer id){
        return kabupatenService.getByKodeProvinsi(id);
    }

    @DeleteMapping("/kabupaten/delete/byId/{id}")
    public ResponseEntity <?> deletedata(@PathVariable Integer id){
        return kabupatenService.deleteKabupaten(id);
    }
}
