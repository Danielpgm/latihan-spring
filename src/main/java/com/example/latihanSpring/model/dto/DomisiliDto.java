package com.example.latihanSpring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomisiliDto {
    private String kelurahan;
    private String kecamatan;
    private String provinsi;
    private String username;
}
