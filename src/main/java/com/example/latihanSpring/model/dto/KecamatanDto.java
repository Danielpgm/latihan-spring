package com.example.latihanSpring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KecamatanDto {
    private String nama;
    private Integer kodekecamatan;
    private String namakabupaten;
    private String namaprovinsi;
}
