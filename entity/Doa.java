package com.example.latihan_praktikum_7.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doa")
public class Doa {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String doa;
    public String ayat;
    public String latin;
    public String artinya;

    public Doa() {}

    public Doa(String doa, String ayat, String latin, String artinya) {
        this.doa = doa;
        this.ayat = ayat;
        this.latin = latin;
        this.artinya = artinya;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getArtinya() {
        return artinya;
    }

    public void setArtinya(String artinya) {
        this.artinya = artinya;
    }
}
