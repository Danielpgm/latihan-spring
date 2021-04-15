package com.example.latihanSpring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesaDto {
    private String nama;
    private Integer kodedesa;
    private String idkecamatan;
    private String idkabupaten;
    private String idprovinsi;
}
