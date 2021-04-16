package com.example.latihanSpring.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.latihanSpring.model.dto.KabupateDto;
import com.example.latihanSpring.model.entity.KabupatenEntity;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
import com.example.latihanSpring.repository.KabupatenRepo;
import com.example.latihanSpring.repository.ProvinsiRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class KabupatenServiceImpl  implements KabupatenService{
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

    @Override
    public ResponseEntity<?> inputKabupaten(List<KabupateDto> dto) {
        Integer index = 0;
        if(dto.get(index).getKodekab() == provinsiRepo.findKodeProvinseByKodeProvinsi(dto.get(index).getKodekab())){
            return ResponseEntity.badRequest().body(dto.get(index).getNama() + " Telah terdaftar" + " dengan kode " + dto.get(index).getKodekab());
        }
        for(KabupateDto kabupateDto: dto){
            convert(kabupateDto);
        }
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> updateKabupaten(Integer id, KabupateDto dto) {
        KabupatenEntity kabupatenEntity= kabupatenRepo.findById(id).get();
        
        kabupatenEntity.setNama(dto.getNama());
        kabupatenRepo.save(kabupatenEntity);

        return ResponseEntity.ok("Kabupaten " +kabupatenRepo.findNamebyName(dto.getKodekab())+" dengan kode "+ id +
        " telah diubah namanya menjadi " + dto.getNama());
    }

    @Override
    public ResponseEntity<?> deleteKabupaten(Integer id) {
        KabupatenEntity kabupatenEntity= kabupatenRepo.findById(id).get();
        kabupatenRepo.delete(kabupatenEntity);
        return ResponseEntity.ok("Data "+ kabupatenEntity.getNama()+" berhasil di hapus!");
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<KabupatenEntity> kab= kabupatenRepo.findAll();
        return ResponseEntity.ok(kab);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        KabupatenEntity kabupatenEntity= kabupatenRepo.findById(id).get();
        return ResponseEntity.ok(kabupatenEntity);
    }

    @Override
    public ResponseEntity<?> getByKodeProvinsi(Integer kode) {
        List<KabupatenEntity> kabupatenEntities= kabupatenRepo.findByKodeProvinsi(kode);
        return ResponseEntity.ok(kabupatenEntities);
    }
}
