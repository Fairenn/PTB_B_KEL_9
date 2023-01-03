package com.pusattugasakhir.models;

public class Peserta {

    String gambar;
    String namaPeserta;
    String nimPeserta;
    int status;

    public Peserta(){

    }

    public Peserta(String gambar, String namaPeserta, String nimPeserta, int status) {
        this.gambar = gambar;
        this.namaPeserta = namaPeserta;
        this.nimPeserta = nimPeserta;
        this.status = status;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public void setNimPeserta(String nimPeserta) {
        this.nimPeserta = nimPeserta;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public String getNimPeserta() {
        return nimPeserta;
    }

    public int getStatus() {
        return status;
    }





}
