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

// @Data
@NoArgsConstructor
@Entity
@Table(name = "pendidikan")
public class Pendidikan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true, nullable = false)
    private String kodependidikan;

    @Column
    private String jenjang;

    @Column
    private String institusi;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserEntity userEntity;

    public Pendidikan(String kodependidikan, String jenjang, String institusi, UserEntity userEntity) {
        this.kodependidikan = kodependidikan;
        this.jenjang = jenjang;
        this.institusi = institusi;
        this.userEntity = userEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKodependidikan() {
        return kodependidikan;
    }

    public void setKodependidikan(String kodependidikan) {
        this.kodependidikan = kodependidikan;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getInstitusi() {
        return institusi;
    }

    public void setInstitusi(String institusi) {
        this.institusi = institusi;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    

}
