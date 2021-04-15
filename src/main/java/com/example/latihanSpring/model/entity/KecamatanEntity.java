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
@Table(name = "kecamatan")
public class KecamatanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nama;

    @Column(unique = true, length = 5)
    private Integer kodeKecamatan;

    @ManyToOne
    @JoinColumn(name = "idKabupaten")
    private KabupatenEntity kabupatenEntity;

    @ManyToOne
    @JoinColumn(name = "idProvinsi")
    private ProvinsiEntity provinsiEntity;

    public KecamatanEntity(String nama, Integer kodeKecamatan, KabupatenEntity kabupatenEntity,
            ProvinsiEntity provinsiEntity) {
        this.nama = nama;
        this.kodeKecamatan = kodeKecamatan;
        this.kabupatenEntity = kabupatenEntity;
        this.provinsiEntity = provinsiEntity;
    }
}
