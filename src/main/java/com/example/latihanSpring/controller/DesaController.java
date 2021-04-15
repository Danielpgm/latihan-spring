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

    private DesaEntity convert(DesaDto dto){
        DesaEntity desaEntity= new DesaEntity();
        desaEntity.setNama(dto.getNama());
        desaEntity.setKodeDesa(dto.getKodedesa());
        desaRepo.save(desaEntity);

        KecamatanEntity kecamatanEntity= kecamatanRepo.findByNama(dto.getIdkecamatan());
        desaEntity.setKecamatanEntity(kecamatanEntity);
        desaRepo.save(desaEntity);

        KabupatenEntity kabupatenEntity= kabupatenRepo.findByNama(dto.getIdkabupaten());
        desaEntity.setKabupatenEntity(kabupatenEntity);
        desaRepo.save(desaEntity);

        ProvinsiEntity provinsiEntity= provinsiRepo.findByNama(dto.getIdprovinsi());
        desaEntity.setProvinsiEntity(provinsiEntity);
        desaRepo.save(desaEntity);
        return desaEntity;
    }

    @PostMapping("/insert/desa")
    public ResponseEntity<?> postprovinsi(@RequestBody List<DesaDto> dto) {
        Integer index = 0;
        if(dto.get(index).getKodedesa() == desaRepo.findKodeKecamatanByKodeKecamatan(dto.get(index).getKodedesa())){
            return ResponseEntity.badRequest().body(dto.get(index).getNama() + " Telah terdaftar" + " dengan kode " + dto.get(index).getKodedesa());
        }
        for(DesaDto desaDto: dto){
            convert(desaDto);
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/desa/get-all")
    public ResponseEntity<?> getAll() {
        List<DesaEntity> desa= desaRepo.findAll();
        return ResponseEntity.ok(desa);
    }

    @GetMapping("/desa/get-{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        DesaEntity desaEntity= desaRepo.findById(id).get();
        return ResponseEntity.ok(desaEntity);
    }

    @PutMapping("/update/desa/{id}")
    public ResponseEntity<?> putProvinsi(@PathVariable Integer id, @RequestBody DesaDto dto){
        DesaEntity desaEntity= new DesaEntity();
        
        desaEntity.setNama(dto.getNama());
        desaRepo.save(desaEntity);

        return ResponseEntity.ok("Kabupaten " +kecamatanRepo.findNamebyName(dto.getKodedesa())+" dengan kode "+ id +
        " telah diubah namanya menjadi " + dto.getNama());
    }

    @DeleteMapping("/desa/delete-{id}")
    public ResponseEntity <?> deletedata(@PathVariable Integer id){
        DesaEntity desaEntity= desaRepo.findById(id).get();
        desaRepo.delete(desaEntity);
        return ResponseEntity.ok("Data "+ desaEntity.getNama()+" berhasil di hapus!");
    }
}
