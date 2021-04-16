package com.example.latihanSpring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "desa")
public class DesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 80)
    private String nama;

    @ManyToOne
    @JoinColumn(name = "idKecamatan")
    private KecamatanEntity kecamatanEntity;

    @ManyToOne
    @JoinColumn(name ="idKabupaten")
    private KabupatenEntity kabupatenEntity;

    @ManyToOne
    @JoinColumn(name = "idProvinsi")
    private ProvinsiEntity provinsiEntity;

    public DesaEntity(String nama, KecamatanEntity kecamatanEntity, KabupatenEntity kabupatenEntity,
            ProvinsiEntity provinsiEntity) {
        this.nama = nama;
        this.kecamatanEntity = kecamatanEntity;
        this.kabupatenEntity = kabupatenEntity;
        this.provinsiEntity = provinsiEntity;
    }
}
