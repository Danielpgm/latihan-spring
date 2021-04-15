package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.KabupatenEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KabupatenRepo extends JpaRepository<KabupatenEntity, Integer>{
    public KabupatenEntity findByNama(String nama);

    @Query(value = "select nama from kabupaten where kode_kabupaten= ?", nativeQuery = true)
    public String findNamebyName(Integer kodeKabupaten);

    @Query(value = "select kode_kabupaten from kabupaten where kode_kabupaten = ?", nativeQuery = true)
    public Integer findKodeKabupatenByKodeKabupaten(Integer kodeKabupaten);
}
