package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.KecamatanDto;
import com.example.latihanSpring.model.entity.KabupatenEntity;
import com.example.latihanSpring.model.entity.KecamatanEntity;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
import com.example.latihanSpring.repository.KabupatenRepo;
import com.example.latihanSpring.repository.KecamatanRepo;
import com.example.latihanSpring.repository.ProvinsiRepo;
import com.example.latihanSpring.service.KecamatanService;

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
public class KecamatanController {
    @Autowired
    private KecamatanRepo kecamatanRepo;
    @Autowired
    private KabupatenRepo kabupatenRepo;
    @Autowired
    private ProvinsiRepo provinsiRepo;
    @Autowired
    private KecamatanService kecamatanService;

    @PostMapping("/insert/kecamatan")
    public ResponseEntity<?> postprovinsi(@RequestBody List<KecamatanDto> dto) {
        return kecamatanService.inputKecamatan(dto);
    }

    @GetMapping("/kecamatan/get/all")
    public ResponseEntity<?> getAll() {
        return kecamatanService.getAll();
    }

    @GetMapping("/kecamatan/getbyId/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return kecamatanService.getById(id);
    }
    
    @GetMapping("/kabupaten/get/bykodeKecamatan/{id}")
    public ResponseEntity<?> getByKodeKabupaten(@PathVariable Integer id){
        return kecamatanService.getByKodeKecamatan(id);
    }

    @PutMapping("/update/kecamatan/{id}")
    public ResponseEntity<?> putProvinsi(@PathVariable Integer id, @RequestBody KecamatanDto dto){
        return kecamatanService.updateKecamatan(id, dto);
    }

    @DeleteMapping("/kecamatan/delete/byId/{id}")
    public ResponseEntity <?> deletedata(@PathVariable Integer id){
        return kecamatanService.deleteKecamatan(id);
    }
}
