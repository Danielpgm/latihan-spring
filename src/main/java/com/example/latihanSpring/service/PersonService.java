package com.example.latihanSpring.service;

import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.entity.PersonEntity;

import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    public PersonEntity insertData(PersonDto insert);
    // public PersonEntity updateData(Integer id, PersonDto update);
}
