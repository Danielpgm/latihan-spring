package com.example.latihanSpring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // pengganti setter and getter
@NoArgsConstructor // pengganti constructor kosong
@Entity
@Table(name = "user") //table baru dengan nama user di database
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    public UserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
