package com.example.latihanSpring.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.latihanSpring.model.dto.KecamatanDto;
import com.example.latihanSpring.model.entity.KabupatenEntity;
import com.example.latihanSpring.model.entity.KecamatanEntity;
import com.example.latihanSpring.model.entity.ProvinsiEntity;
import com.example.latihanSpring.repository.KabupatenRepo;
import com.example.latihanSpring.repository.KecamatanRepo;
import com.example.latihanSpring.repository.ProvinsiRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService {

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

    @Override
    public ResponseEntity<?> inputKecamatan(List<KecamatanDto> dto) {
        Integer index = 0;
        if(dto.get(index).getKodekecamatan() == kecamatanRepo.findKodeKecamatanByKodeKecamatan(dto.get(index).getKodekecamatan())){
            return ResponseEntity.badRequest().body(dto.get(index).getNama() + " Telah terdaftar" + " dengan kode " + dto.get(index).getKodekecamatan());
        }
        for(KecamatanDto kecamatanDto: dto){
            convert(kecamatanDto);
        }
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<KecamatanEntity> kec= kecamatanRepo.findAll();
        return ResponseEntity.ok(kec);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        KecamatanEntity kecamatanEntity= kecamatanRepo.findById(id).get();
        return ResponseEntity.ok(kecamatanEntity);
    }
    
    @Override
    public ResponseEntity<?> getByKodeKecamatan(Integer kode) {
        List<KecamatanEntity> kecamatanEntities= kecamatanRepo.findByKodeProvinsi(kode);
        return ResponseEntity.ok(kecamatanEntities);
    }
    
    @Override
    public ResponseEntity<?> deleteKecamatan(Integer id) {
        KecamatanEntity kecamatanEntity= kecamatanRepo.findById(id).get();
        kecamatanRepo.delete(kecamatanEntity);
        return ResponseEntity.ok("Data "+ kecamatanEntity.getNama()+" berhasil di hapus!");
    }

    @Override
    public ResponseEntity<?> updateKecamatan(Integer id, KecamatanDto dto) {
        ProvinsiEntity provinsiEntity= provinsiRepo.findById(id).get();
        
        provinsiEntity.setNama(dto.getNama());
        provinsiRepo.save(provinsiEntity);

        return ResponseEntity.ok(provinsiEntity);
    }
    
}
