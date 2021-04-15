package com.example.latihanSpring.controller;

import java.util.List;

import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.entity.PersonEntity;
import com.example.latihanSpring.repository.PersonRepository;
import com.example.latihanSpring.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


// DIGUNAKAN UNTUK AKSES KE DATABASE SEPERTI INSERT, READ, UPDATE, DELETE
// ATAU DIGUNAKAN UNTUK MANIPULASI DATA

@RestController
@RequestMapping("/v1/")
public class PersonControler {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    // Method untuk get data di dalam table database latihan_person
    @GetMapping("/persons")
    public List<PersonEntity> getPersons() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons;
    }
    
    // METHOD UNTUK POST KE TABLE PERSONS
    @PostMapping("/insert/person")
    public ResponseEntity<?> insertPerson(@RequestBody PersonDto personDto){
        // PersonEntity personEntity= new PersonEntity();

        // CONVERT DTO TO ENTITY
        // personEntity.setFirtsName(personDto.getFirstname());
        // personEntity.setLastName(personDto.getLastname());
        // personEntity.setDomisili(personDto.getDomisili());
        // personEntity.setDateofBirth(personDto.getTanggal());
        // personRepository.save(personEntity);

        // TRANSFER DATA MELALUI SERVICE
        PersonEntity personEntity= personService.insertData(personDto);
        return ResponseEntity.ok(personEntity);
    }

    // GET BY ID
    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Integer id){
        PersonEntity personEntity= personRepository.findById(id).get();
        return ResponseEntity.ok(personEntity);
    }
    
    // UPDATE
    @PutMapping("/update/person/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody PersonDto pdto){
        // PersonEntity personEntity= personRepository.findById(id).get();
        
        // personEntity.setFirtsName(pdto.getFirstname());
        // personEntity.setLastName(pdto.getLastname());
        // personEntity.setDomisili(pdto.getDomisili());
        // personEntity.setDateofBirth(pdto.getTanggal());
        // personRepository.save(personEntity);

        // UPDATE DATA MELALUI SERVICE
        PersonEntity personEntity= personService.updateData(id, pdto);
        return ResponseEntity.ok(personEntity);
    }

    // Delete
    @DeleteMapping("/delete/person/{id}")
    public ResponseEntity<?> deleteperson(@PathVariable Integer id){
        PersonEntity personEntity= personRepository.findById(id).get();
        personRepository.delete(personEntity);

        return ResponseEntity.ok(personEntity);
    }
}   
