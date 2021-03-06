package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.DesaDto;
import com.example.latihanSpring.model.entity.DesaEntity;
import com.example.latihanSpring.model.entity.KabupatenEntity;
import com.example.latihanSpring.model.entity.KecamatanEntity;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
import com.example.latihanSpring.repository.DesaRepo;
import com.example.latihanSpring.repository.KabupatenRepo;
import com.example.latihanSpring.repository.KecamatanRepo;
import com.example.latihanSpring.repository.ProvinsiRepo;
import com.example.latihanSpring.service.DesaService;

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
public class DesaController {
    @Autowired
    private DesaRepo desaRepo;
    @Autowired
    private KecamatanRepo kecamatanRepo;
    @Autowired
    private KabupatenRepo kabupatenRepo;
    @Autowired
    private ProvinsiRepo provinsiRepo;
    @Autowired
    private DesaService desaService;

    private DesaEntity convert(DesaDto dto){
        DesaEntity desaEntity= new DesaEntity();
        desaEntity.setNama(dto.getNama());
        desaRepo.save(desaEntity);

        KecamatanEntity kecamatanEntity= kecamatanRepo.findByNama(dto.getNamakecamatan());
        desaEntity.setKecamatanEntity(kecamatanEntity);
        desaRepo.save(desaEntity);

        KabupatenEntity kabupatenEntity= kabupatenRepo.findByNama(dto.getNamakabupaten());
        desaEntity.setKabupatenEntity(kabupatenEntity);
        desaRepo.save(desaEntity);

        ProvinsiEntity provinsiEntity= provinsiRepo.findByNama(dto.getNamaprovinsi());
        desaEntity.setProvinsiEntity(provinsiEntity);
        desaRepo.save(desaEntity);
        return desaEntity;
    }

    @PostMapping("/insert/desa")
    public ResponseEntity<?> postprovinsi(@RequestBody List<DesaDto> dto) {
        return desaService.inputDesa(dto);
    }

    @GetMapping("/desa/get/all")
    public ResponseEntity<?> getAll() {
        return desaService.getAll();
    }

    @GetMapping("/desa/get/byId/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return desaService.getById(id);
    }

    @PutMapping("/update/desa/{id}")
    public ResponseEntity<?> putProvinsi(@PathVariable Integer id, @RequestBody DesaDto dto){
        return desaService.updateDesa(id, dto);
    }

    @DeleteMapping("/desa/delete-{id}")
    public ResponseEntity <?> deletedata(@PathVariable Integer id){
        return desaService.deleteDesa(id);
    }
}
