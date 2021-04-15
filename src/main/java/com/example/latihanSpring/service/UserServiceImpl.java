package com.example.latihanSpring.service;

import javax.transaction.Transactional;

import com.example.latihanSpring.model.dto.DomisiliDto;
import com.example.latihanSpring.model.dto.PersonDto;
import com.example.latihanSpring.model.dto.StatusMessageDto;
import com.example.latihanSpring.model.entity.DetailUserEntity;
import com.example.latihanSpring.model.entity.DomisiliEntity;
import com.example.latihanSpring.model.entity.Pendidikan;
import com.example.latihanSpring.model.entity.UserEntity;
import com.example.latihanSpring.repository.DetailUserRepo;
import com.example.latihanSpring.repository.DomisiliRepo;
import com.example.latihanSpring.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private DetailUserRepo detailUserRepo;
    @Autowired
    private DomisiliRepo domisiliRepo;

    @Override
    public ResponseEntity<?> regisUser(PersonDto dto) {

        StatusMessageDto<UserEntity> result= new StatusMessageDto<>();

        if(dto.getNik().length() != 16){
            result.setStatus(HttpStatus.BAD_REQUEST.value());
            result.setMessage("NIK harus berisi 16 nomor");
            return ResponseEntity.badRequest().body(result);
        }
        
        UserEntity userEntity= new UserEntity();
        DetailUserEntity detailUserEntity= new DetailUserEntity();
        
        userEntity.setUsername(dto.getUsername());
        userEntity.setPassword(dto.getPassword());
        userRepo.save(userEntity);
        
        detailUserEntity.setNik(dto.getNik());
        detailUserEntity.setFirstname(dto.getFirstname());
        detailUserEntity.setLastname(dto.getLastname());
        detailUserEntity.setDomisili(dto.getDomisili());
        detailUserEntity.setGolDarah(dto.getGoldarah());
        detailUserEntity.setTanggal(dto.getTanggal());
        detailUserEntity.setUserEntity(userEntity);
        detailUserRepo.save(detailUserEntity);
        
        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil tersimpan");
        result.setData(userEntity);
        
        return ResponseEntity.ok(result);
    }
}
