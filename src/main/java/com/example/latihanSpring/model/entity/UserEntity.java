package com.example.latihanSpring.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 25) 
    // "unique" properties for unique table
    // "nullable = false" properties for make sure this column not null
    // "length" = to declare length in that column
    private String username;

    @Column(nullable = false)
    private String password;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
