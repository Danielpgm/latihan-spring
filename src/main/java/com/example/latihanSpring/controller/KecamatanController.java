package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.KecamatanDto;
import com.example.latihanSpring.model.entity.KabupatenEntity;
import com.example.latihanSpring.model.entity.KecamatanEntity;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
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
public class KecamatanController {
    @Autowired
    private KecamatanRepo kecamatanRepo;
    @Autowired
    private KabupatenRepo kabupatenRepo;
    @Autowired
    private ProvinsiRepo provinsiRepo;

    private KecamatanEntity convert(KecamatanDto dto){
        KecamatanEntity kecamatanEntity= new KecamatanEntity();
        kecamatanEntity.setNama(dto.getNama());
        kecamatanEntity.setKodeKecamatan(dto.getKodekecamatan());
        kecamatanRepo.save(kecamatanEntity);

        KabupatenEntity kabupatenEntity= kabupatenRepo.findByNama(dto.getNamakabupaten());
        kecamatanEntity.setKabupatenEntity(kabupatenEntity);
        kecamatanRepo.save(kecamatanEntity);

        ProvinsiEntity provinsiEntity= provinsiRepo.findByNama(dto.getNamaprovinsi());
        kecamatanEntity.setProvinsiEntity(provinsiEntity);
        kecamatanRepo.save(kecamatanEntity);
        return kecamatanEntity;
    }

    @PostMapping("/insert/kecamatan")
    public ResponseEntity<?> postprovinsi(@RequestBody List<KecamatanDto> dto) {
        Integer index = 0;
        if(dto.get(index).getKodekecamatan() == kecamatanRepo.findKodeKecamatanByKodeKecamatan(dto.get(index).getKodekecamatan())){
            return ResponseEntity.badRequest().body(dto.get(index).getNama() + " Telah terdaftar" + " dengan kode " + dto.get(index).getKodekecamatan());
        }
        for(KecamatanDto kecamatanDto: dto){
            convert(kecamatanDto);
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/kecamatan/get-all")
    public ResponseEntity<?> getAll() {
        List<KecamatanEntity> kec= kecamatanRepo.findAll();
        return ResponseEntity.ok(kec);
    }

    @GetMapping("/kecamatan/get-{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        KecamatanEntity kecamatanEntity= kecamatanRepo.findById(id).get();
        return ResponseEntity.ok(kecamatanEntity);
    }

    @PutMapping("/update/kecamatan/{id}")
    public ResponseEntity<?> putProvinsi(@PathVariable Integer id, @RequestBody KecamatanDto dto){
        ProvinsiEntity provinsiEntity= new ProvinsiEntity();
        
        provinsiEntity.setNama(dto.getNama());
        provinsiRepo.save(provinsiEntity);

        return ResponseEntity.ok("Kabupaten " +kecamatanRepo.findNamebyName(dto.getKodekecamatan())+" dengan kode "+ id +
        " telah diubah namanya menjadi " + dto.getNama());
    }

    @DeleteMapping("/kecamatan/delete-{id}")
    public ResponseEntity <?> deletedata(@PathVariable Integer id){
        KecamatanEntity kecamatanEntity= kecamatanRepo.findById(id).get();
        kecamatanRepo.delete(kecamatanEntity);
        return ResponseEntity.ok("Data "+ kecamatanEntity.getNama()+" berhasil di hapus!");
    }
}
