// CLASS INI DIGUNAKAN UNTUK

package com.example.latihanSpring.model.dto;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String domisili;
    private Date tanggal;
    private String nik;
    private String golDarah;

    public PersonDto(String username, String password, String firstname, String lastname, String domisili, Date tanggal,
        String nik, String golDarah) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.domisili = domisili;
        this.tanggal = tanggal;
        this.nik = nik;
        this.golDarah = golDarah;
    }

    // SETTER AND GETTER
    // JIKA MENGGUNAKAN @DATA TIDAK PERLU MENGGUNAKAN SETTER DAN GETTER LAGI 
    // public String getUsername() {
    //     return username;
    // }
    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // public String getPassword() {
    //     return password;
    // }
    // public void setPassword(String password) {
    //     this.password = password;
    // }

    // public String getFirstname() {
    //     return firstname;
    // }
    // public void setFirstname(String firstname) {
    //     this.firstname = firstname;
    // }

    // public String getLastname() {
    //     return lastname;
    // }
    // public void setLastname(String lastname) {
    //     this.lastname = lastname;
    // }

    // public String getDomisili() {
    //     return domisili;
    // }
    // public void setDomisili(String domisili) {
    //     this.domisili = domisili;
    // }

    // public Date getTanggal() {
    //     return tanggal;
    // }
    // public void setTanggal(Date tanggal) {
    //     this.tanggal = tanggal;
    // }

    // public String getNik() {
    //     return nik;
    // }
    // public void setNik(String nik) {
    //     this.nik = nik;
    // }

    // public String getGolDarah() {
    //     return golDarah;
    // }
    // public void setGolDarah(String golDarah) {
    //     this.golDarah = golDarah;
    // }
}
