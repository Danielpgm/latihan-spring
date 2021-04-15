package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.ProvinsiEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinsiRepo extends JpaRepository<ProvinsiEntity, Integer> {
    public ProvinsiEntity findByNama(String nama);

    @Query(value = "select kode_provinsi from provinsi where kode_provinsi = ?", nativeQuery = true)
    public Integer findKodeProvinseByKodeProvinsi(Integer kodeprovinsi);

    @Query(value = "select nama from provinsi where kode_provinsi= ?", nativeQuery = true)
    public String findNamebyName(Integer kodeprovinsi);
}
