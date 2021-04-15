package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.KabupateDto;
import com.example.latihanSpring.model.entity.KabupatenEntity;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
import com.example.latihanSpring.repository.KabupatenRepo;
import com.example.latihanSpring.repository.ProvinsiRepo;

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

    private KabupatenEntity convert(KabupateDto dto){
        KabupatenEntity kabupatenEntity= new KabupatenEntity();
        kabupatenEntity.setNama(dto.getNama());
        kabupatenEntity.setKodeKabupaten(dto.getKodekab());
        kabupatenRepo.save(kabupatenEntity);

        ProvinsiEntity provinsiEntity= provinsiRepo.findByNama(dto.getProvnama());
        kabupatenEntity.setProvinsiEntity(provinsiEntity);
        kabupatenRepo.save(kabupatenEntity);
        return kabupatenEntity;
    }

    @PostMapping("/insert/kabupaten")
    public ResponseEntity<?> postprovinsi(@RequestBody List<KabupateDto> dto) {
        Integer index = 0;
        if(dto.get(index).getKodekab() == provinsiRepo.findKodeProvinseByKodeProvinsi(dto.get(index).getKodekab())){
            return ResponseEntity.badRequest().body(dto.get(index).getNama() + " Telah terdaftar" + " dengan kode " + dto.get(index).getKodekab());
        }
        for(KabupateDto kabupateDto: dto){
            convert(kabupateDto);
        }
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/update/kabupaten/{id}")
    public ResponseEntity<?> putProvinsi(@PathVariable Integer id, @RequestBody KabupateDto dto){
        ProvinsiEntity provinsiEntity= new ProvinsiEntity();
        
        provinsiEntity.setNama(dto.getNama());
        provinsiRepo.save(provinsiEntity);

        return ResponseEntity.ok("Kabupaten " +kabupatenRepo.findNamebyName(dto.getKodekab())+" dengan kode "+ id +
        " telah diubah namanya menjadi " + dto.getNama());
    }

    @GetMapping("/kabupaten/get-all")
    public ResponseEntity<?> getAll() {
        List<KabupatenEntity> kab= kabupatenRepo.findAll();
        return ResponseEntity.ok(kab);
    }

    @GetMapping("/kabupaten/get-{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        KabupatenEntity kabupatenEntity= kabupatenRepo.findById(id).get();
        return ResponseEntity.ok(kabupatenEntity);
    }

    @DeleteMapping("/kabupaten/delete-{id}")
    public ResponseEntity <?> deletedata(@PathVariable Integer id){
        KabupatenEntity kabupatenEntity= kabupatenRepo.findById(id).get();
        kabupatenRepo.delete(kabupatenEntity);
        return ResponseEntity.ok("Data "+ kabupatenEntity.getNama()+" berhasil di hapus!");
    }
}
