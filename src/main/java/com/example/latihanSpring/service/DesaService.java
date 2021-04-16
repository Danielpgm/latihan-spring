package com.example.latihanSpring.service;

import java.util.List;

import com.example.latihanSpring.model.dto.DesaDto;

import org.springframework.http.ResponseEntity;

public interface DesaService {
    public ResponseEntity<?> inputDesa(List<DesaDto> dto);
    public ResponseEntity<?> updateDesa(Integer id, DesaDto dto);
    public ResponseEntity<?> deleteDesa(Integer id);
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getById(Integer id);
}
