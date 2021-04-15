package com.example.latihanSpring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "provinsi")
public class ProvinsiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nama;

    @Column(unique =  true, length = 5)
    private Integer kodeProvinsi;

    public ProvinsiEntity(String nama, Integer kodeProvinsi) {
        this.nama = nama;
        this.kodeProvinsi = kodeProvinsi;
    }
}
