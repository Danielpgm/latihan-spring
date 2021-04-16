package com.example.latihanSpring.service;

import java.util.List;

import com.example.latihanSpring.model.dto.ProvinsiDto;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
import com.example.latihanSpring.repository.ProvinsiRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService{
    @Autowired
    private ProvinsiRepo provinsiRepo;

    private ProvinsiEntity convert(ProvinsiDto dto){
        ProvinsiEntity provinsiEntity= new ProvinsiEntity();
        provinsiEntity.setNama(dto.getNama());
        provinsiEntity.setKodeProvinsi(dto.getKodeprovinsi());
    
        provinsiRepo.save(provinsiEntity);
        return provinsiEntity;
    }

    @Override
    public ResponseEntity<?> inputprovinsi(List<ProvinsiDto> dto) {
        Integer index = 0;
        if(dto.get(index).getKodeprovinsi() == provinsiRepo.findKodeProvinseByKodeProvinsi(dto.get(index).getKodeprovinsi())){
            return ResponseEntity.badRequest().body(dto.get(index).getNama() + " Telah terdaftar" + " dengan kode " + dto.get(index).getKodeprovinsi());
        }
        for(ProvinsiDto provinsiDto: dto){
            convert(provinsiDto);
        }
        return ResponseEntity.ok(dto);
    }

    
    
    @Override
    public ResponseEntity<?> updateProvinsi(Integer id, ProvinsiDto dto) {
        ProvinsiEntity provinsiEntity= provinsiRepo.findById(id).get();

        provinsiEntity.setNama(dto.getNama());

        provinsiRepo.save(provinsiEntity);
        return ResponseEntity.ok("Provinsi dengan id "+ id +
        " telah diubah namanya menjadi " + dto.getNama());
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<ProvinsiEntity> prov= provinsiRepo.findAll();
        return ResponseEntity.ok(prov);
    }
    
    @Override
    public ResponseEntity<?> getById(Integer id) {
        ProvinsiEntity provinsiEntity= provinsiRepo.findById(id).get();
        return ResponseEntity.ok(provinsiEntity);
    }

    @Override
    public ResponseEntity<?> getByKodeProvinsi(Integer kode) {
        List<ProvinsiEntity> provinsiEntity= provinsiRepo.findByKodeProvinsi(kode);
        return ResponseEntity.ok(provinsiEntity);
    }
    
    @Override
    public ResponseEntity<?> deleteData(Integer id) {
        ProvinsiEntity provinsiEntity= provinsiRepo.findById(id).get();
        provinsiRepo.delete(provinsiEntity);
        return ResponseEntity.ok("Data berhasil di hapus!");
    }    
}
