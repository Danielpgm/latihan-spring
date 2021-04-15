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
@Table(name = "kabupaten")
public class KabupatenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 50)
    private String nama;

    @Column(length = 4)
    private Integer kodeKabupaten;

    @ManyToOne
    @JoinColumn(name = "provinsi")
    private ProvinsiEntity provinsiEntity;

    public KabupatenEntity(String nama, Integer kodeKabupaten, ProvinsiEntity provinsiEntity) {
        this.nama = nama;
        this.kodeKabupaten = kodeKabupaten;
        this.provinsiEntity = provinsiEntity;
    }
}
