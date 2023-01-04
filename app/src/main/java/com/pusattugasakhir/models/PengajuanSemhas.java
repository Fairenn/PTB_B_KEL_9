package com.pusattugasakhir.models;

public class PengajuanSemhas {
    private String namaAju;
    private String nimAju;
    private String judulSemhasAju;
    private String pembimbingAju1;
    private String pembimbingAju2;
    private String pengujiAju1;
    private String pengujiAju2;

    public PengajuanSemhas(String namaAju, String nimAju, String judulSemhasAju, String pembimbingAju1, String pembimbingAju2, String pengujiAju1, String pengujiAju2) {
        this.namaAju = namaAju;
        this.nimAju = nimAju;
        this.judulSemhasAju = judulSemhasAju;
        this.pembimbingAju1 = pembimbingAju1;
        this.pembimbingAju2 = pembimbingAju2;
        this.pengujiAju1 = pengujiAju1;
        this.pengujiAju2 = pengujiAju2;
    }

    public String getNamaAju() {
        return namaAju;
    }

    public void setNamaAju(String namaAju) {
        this.namaAju = namaAju;
    }

    public String getNimAju() {
        return nimAju;
    }

    public void setNimAju(String nimAju) {
        this.nimAju = nimAju;
    }

    public String getJudulSemhasAju() {
        return judulSemhasAju;
    }

    public void setJudulSemhasAju(String judulSemhasAju) {
        this.judulSemhasAju = judulSemhasAju;
    }

    public String getPembimbingAju1() {
        return pembimbingAju1;
    }

    public void setPembimbingAju1(String pembimbingAju1) {
        this.pembimbingAju1 = pembimbingAju1;
    }

    public String getPembimbingAju2() {
        return pembimbingAju2;
    }

    public void setPembimbingAju2(String pembimbingAju2) {
        this.pembimbingAju2 = pembimbingAju2;
    }

    public String getPengujiAju1() {
        return pengujiAju1;
    }

    public void setPengujiAju1(String pengujiAju1) {
        this.pengujiAju1 = pengujiAju1;
    }

    public String getPengujiAju2() {
        return pengujiAju2;
    }

    public void setPengujiAju2(String pengujiAju2) {
        this.pengujiAju2 = pengujiAju2;
    }
}
