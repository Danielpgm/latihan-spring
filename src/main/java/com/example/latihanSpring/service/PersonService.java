package com.example.latihanSpring.service;

import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.entity.PersonEntity;

public interface PersonService {
    public PersonEntity insertData(PersonDto insert);
    public PersonEntity updateData(Integer id, PersonDto update);
}
