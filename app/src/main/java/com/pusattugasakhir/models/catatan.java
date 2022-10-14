package com.pusattugasakhir.models;

public class catatan {
    String catatan;
    String tanggal;

    public catatan(){

    }

    public catatan(String catatan, String tanggal) {
        this.catatan = catatan;
        this.tanggal = tanggal;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}