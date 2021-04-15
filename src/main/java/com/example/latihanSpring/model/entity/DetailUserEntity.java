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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // empty constructor
@Entity // annotation that declare this class is an entity
@Table(name = "detail_user")  // annotation declare for create table "detail_user" in database
public class DetailUserEntity {
    @Id //primary key for column id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generated values and auto increament
    private Integer id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String domisili;

    @Column
    private Date tanggal;

    @Column
    private String nik;

    @Column
    private String golDarah;

    @OneToOne // annotation for reation in databse (1 to 1)
    @JoinColumn(name = "userId") // create column for foreign key between detailuser and user
    private UserEntity userEntity; // getting data from userEntity

    public DetailUserEntity(String firstname, String lastname, String domisili,
            Date tanggal, String nik, String golDarah) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.domisili = domisili;
        this.tanggal = tanggal;
        this.nik = nik;
        this.golDarah = golDarah;
    }

    
}
