package com.example.latihanSpring.repository;

import java.util.List;

import com.example.latihanSpring.model.entity.KecamatanEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KecamatanRepo extends JpaRepository<KecamatanEntity, Integer>{
    public KecamatanEntity findByNama(String nama);

    @Query(value = "select kode_kecamatan from kecamatan where kode_kecamatan = ?", nativeQuery = true)
    public Integer findKodeKecamatanByKodeKecamatan(Integer kodeprovinsi);

    @Query(value = "select * from kabupaten where kode_kabupaten= ?", nativeQuery = true)
    List<KecamatanEntity> findByKodeProvinsi(Integer kode);
}
