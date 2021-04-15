package com.example.latihanSpring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "domisili")
public class DomisiliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String kelurahan;

    @Column
    private String kecamatan;

    @Column
    private String provinsi;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserEntity userEntity;

    public DomisiliEntity(String kelurahan, String kecamatan, String provinsi, UserEntity userEntity) {
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.provinsi = provinsi;
        this.userEntity = userEntity;
    }

    
}
