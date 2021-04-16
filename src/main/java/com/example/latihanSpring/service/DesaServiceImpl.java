package com.example.latihanSpring.service;

import java.util.List;

import javax.transaction.Transactional;

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
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DesaServiceImpl implements DesaService {

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
    
    @Override
    public ResponseEntity<?> inputDesa(List<DesaDto> dto) {
        
        for(DesaDto desaDto: dto){
            convert(desaDto);
        }
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> deleteDesa(Integer id) {
        DesaEntity desaEntity= desaRepo.findById(id).get();
        desaRepo.delete(desaEntity);
        return ResponseEntity.ok("Data "+ desaEntity.getNama()+" berhasil di hapus!");
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<DesaEntity> desa= desaRepo.findAll();
        return ResponseEntity.ok(desa);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        DesaEntity desaEntity= desaRepo.findById(id).get();
        return ResponseEntity.ok(desaEntity);
    }
    
    @Override
    public ResponseEntity<?> updateDesa(Integer id, DesaDto dto) {
        DesaEntity desaEntity= desaRepo.findById(id).get();
        
        desaEntity.setNama(dto.getNama());
        desaRepo.save(desaEntity);

        return ResponseEntity.ok("data telah diupdate");
    }
    
}
