package com.example.latihan_praktikum_7.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.latihan_praktikum_7.entity.Doa;

import java.util.List;

@Dao
public interface DoaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Doa> doaList);

    @Query("SELECT * FROM doa WHERE doa LIKE '%' || :keyword || '%' ")
    List<Doa> searchDoa(String keyword);

    @Query("SELECT * FROM doa")
    List<Doa> getAllDoa();
}
