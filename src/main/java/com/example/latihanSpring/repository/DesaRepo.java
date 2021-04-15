package com.example.latihanSpring.repository;

import com.example.latihanSpring.model.entity.DesaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DesaRepo extends JpaRepository<DesaEntity, Integer>{
    @Query(value = "select kode_desa from desa where kode_desa = ?", nativeQuery = true)
    public Integer findKodeKecamatanByKodeKecamatan(Integer kodeDesa);

    @Query(value = "select nama from desa where kode_desa= ?", nativeQuery = true)
    public String findNamebyName(Integer kodeDesa);
}
