package com.example.latihanSpring.service;

import java.util.List;

import com.example.latihanSpring.model.dto.KabupateDto;

import org.springframework.http.ResponseEntity;

public interface KabupatenService {
    public ResponseEntity<?> inputKabupaten(List<KabupateDto> dto);
    public ResponseEntity<?> updateKabupaten(Integer id, KabupateDto dto);
    public ResponseEntity<?> deleteKabupaten(Integer id);
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getById(Integer id);
    public ResponseEntity<?> getByKodeProvinsi(Integer kodeProvinsi);
}
