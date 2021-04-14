package com.example.latihanSpring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// import org.hibernate.annotations.Columns;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// DIGUNAKAN UNTUK MEMBUAT TABLE PERSONS {@Table(name = "persons")} SERTA MEMBUAT LENGTH,
// AUTO_INCREAMENT, PRIMARY KEY, 
// UNTUK TRANSFER DATA DARI

@Data
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id // ANOTASI UNTUK PRIsMARY KEY DALAM SUATU ENTITY
    @Column(length = 11) // ANOTASI YANG DIGUNAKAN UNTUK MENENTUKAN COLUMN DALAM DATABASE
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 50) // HARUS ADA JIKA KITA INGIN MEMBUAT "COLUMN" DALAM SUATU TABLE DI DATABASE
    private String firtsName, lastName;

    @Column(length = 50)
    private String domisili;

    // TEMPORAL UNTUK MENGGUNAKAN DATE (Java.util.Date or java.util.Calendar)
    @Temporal(value = TemporalType.DATE)
    @Column(name = "bDate")
    private Date dateofBirth;

    // CONSTRUCTOR DENGAN PARAMETER
        public PersonEntity(String firtsName, String lastName, String domisili, Date dateofBirth) {
            this.firtsName = firtsName;
            this.lastName = lastName;
            this.domisili = domisili;
            this.dateofBirth = dateofBirth;
        }
    
    // GETTER AND SETTER
        // public int getId() {
        //     return id;
        // }
        // public void setId(int id) {
        //     this.id = id;
        // }

        // public String getFirtsName() {
        //     return firtsName;
        // }
        // public void setFirtsName(String firtsName) {
        //     this.firtsName = firtsName;
        // }

        // public String getLastName() {
        //     return lastName;
        // }
        // public void setLastName(String lastName) {
        //     this.lastName = lastName;
        // }

        // public String getDomisili() {
        //     return domisili;
        // }
        // public void setDomisili(String domisili) {
        //     this.domisili = domisili;
        // }

        // public Date getDateofBirth() {
        //     return dateofBirth;
        // }
        // public void setDateofBirth(Date dateofBirth) {
        //     this.dateofBirth = dateofBirth;
        // }
}
