package com.pusattugasakhir.models;

public class Peserta {

    String imagePeserta;
    String namaPeserta;
    String nimPeserta;


    public Peserta(){

    }

    public Peserta(String imagePeserta, String namaPeserta, String nimPeserta) {
        this.imagePeserta = imagePeserta;
        this.namaPeserta = namaPeserta;
        this.nimPeserta = nimPeserta;

    }

    public void setimagePeserta(String imagePeserta) {
        this.imagePeserta = imagePeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public void setNimPeserta(String nimPeserta) {
        this.nimPeserta = nimPeserta;
    }



    public String getimagePeserta() {
        return imagePeserta;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public String getNimPeserta() {
        return nimPeserta;
    }







}
