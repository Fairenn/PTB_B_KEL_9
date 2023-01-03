package com.pusattugasakhir.models;

public class Peserta {

    String imagePeserta;
    String namaPeserta;
    String nimPeserta;
    int imageStatus;

    public Peserta(){

    }

    public Peserta(String imagePeserta, String namaPeserta, String nimPeserta, int imageStatus) {
        this.imagePeserta = imagePeserta;
        this.namaPeserta = namaPeserta;
        this.nimPeserta = nimPeserta;
        this.imageStatus = imageStatus;
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

    public void setimageStatus(int imageStatus) {
        this.imageStatus = imageStatus;
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

    public int getimageStatus() {
        return imageStatus;
    }





}
