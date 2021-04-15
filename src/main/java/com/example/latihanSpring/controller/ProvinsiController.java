package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.ProvinsiDto;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
import com.example.latihanSpring.repository.ProvinsiRepo;

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
    private ProvinsiRepo provinsiRepo;

    private ProvinsiEntity convert(ProvinsiDto dto){
        ProvinsiEntity provinsiEntity= new ProvinsiEntity();
        provinsiEntity.setNama(dto.getNama());
        provinsiEntity.setKodeProvinsi(dto.getKodeprovinsi());
    
        provinsiRepo.save(provinsiEntity);
        return provinsiEntity;
    }

    @PostMapping("/insert/provinsi")
    public ResponseEntity<?> postprovinsi(@RequestBody List<ProvinsiDto> dto) {
        Integer index = 0;
        if(dto.get(index).getKodeprovinsi() == provinsiRepo.findKodeProvinseByKodeProvinsi(dto.get(index).getKodeprovinsi())){
            return ResponseEntity.badRequest().body(dto.get(index).getNama() + " Telah terdaftar" + " dengan kode " + dto.get(index).getKodeprovinsi());
        }
        for(ProvinsiDto provinsiDto: dto){
            convert(provinsiDto);
        }
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/update/provinsi/{id}")
    public ResponseEntity<?> putProvinsi(@PathVariable Integer id, @RequestBody ProvinsiDto dto){
        ProvinsiEntity provinsiEntity= new ProvinsiEntity();
        
        provinsiEntity.setNama(dto.getNama());
        provinsiRepo.save(provinsiEntity);
        return ResponseEntity.ok("Provinsi " +provinsiRepo.findNamebyName(dto.getKodeprovinsi())+" dengan kode "+ id +
        " telah diubah namanya menjadi " + dto.getNama());
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        List<ProvinsiEntity> prov= provinsiRepo.findAll();
        return ResponseEntity.ok(prov);
    }

    @GetMapping("/get-{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        ProvinsiEntity provinsiEntity= provinsiRepo.findById(id).get();
        return ResponseEntity.ok(provinsiEntity);
    }

    @DeleteMapping("/delete-{id}")
    public ResponseEntity <?> deletedata(@PathVariable Integer id){
        ProvinsiEntity provinsiEntity= provinsiRepo.findById(id).get();
        provinsiRepo.delete(provinsiEntity);
        return ResponseEntity.ok("Data berhasil di hapus!");
    }
}
