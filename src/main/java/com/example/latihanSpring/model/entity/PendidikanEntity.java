package com.example.latihanSpring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pendidikan")
public class PendidikanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String kodePendidikan;

    @Column
    private String jenjang;

    @Column
    private String institusi;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserEntity userEntity;

    public PendidikanEntity(String kodePendidikan, String jenjang, String institusi, UserEntity userEntity) {
        this.kodePendidikan = kodePendidikan;
        this.jenjang = jenjang;
        this.institusi = institusi;
        this.userEntity = userEntity;
    }

    
}