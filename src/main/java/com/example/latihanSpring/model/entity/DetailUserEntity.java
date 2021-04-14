package com.example.latihanSpring.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detail_user")
public class DetailUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String nik;

    @Column
    private String domisili;

    @Temporal(value = TemporalType.DATE)
    @Column
    private Date tanggalLahir;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    public DetailUserEntity(String firstname, String lastname, String nik, String domisili, Date tanggalLahir,
            UserEntity userEntity) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nik = nik;
        this.domisili = domisili;
        this.tanggalLahir = tanggalLahir;
        this.userEntity = userEntity;
    }
}
