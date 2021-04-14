package com.example.latihanSpring.service;

import javax.transaction.Transactional;

import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.entity.PersonEntity;
import com.example.latihanSpring.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonEntity insertData(PersonDto insert) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setFirtsName(insert.getFirstname());
        personEntity.setLastName(insert.getLastname());
        personEntity.setDomisili(insert.getDomisili());
        personEntity.setDateofBirth(insert.getTanggal());
        personRepository.save(personEntity);

        return personEntity;
    }

    // @Override
    // public PersonEntity updateData(Integer id, PersonDto update) {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    
}
