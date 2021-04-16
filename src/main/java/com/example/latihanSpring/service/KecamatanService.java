package com.example.latihanSpring.service;

import java.util.List;

import com.example.latihanSpring.model.dto.KecamatanDto;
import com.example.latihanSpring.model.entity.KecamatanEntity;

import org.springframework.http.ResponseEntity;

public interface KecamatanService {
    public ResponseEntity<?> inputKecamatan(List<KecamatanDto> dto);
    public ResponseEntity<?> updateKecamatan(Integer id, KecamatanDto dto);
    public ResponseEntity<?> deleteKecamatan(Integer id);
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getById(Integer id);
    public ResponseEntity<?> getByKodeKecamatan(Integer kodeProvinsi);
}
