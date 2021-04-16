package com.example.latihanSpring.service;

import java.util.List;

import com.example.latihanSpring.model.dto.ProvinsiDto;

import org.springframework.http.ResponseEntity;

public interface ProvinsiService {
    public ResponseEntity<?> inputprovinsi(List<ProvinsiDto> dto);
    public ResponseEntity<?> updateProvinsi(Integer id, ProvinsiDto dto);
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getById(Integer id);
    public ResponseEntity<?> getByKodeProvinsi(Integer kodeProvinsi);
    public ResponseEntity<?> deleteData(Integer id);
}
