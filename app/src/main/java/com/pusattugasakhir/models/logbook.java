package com.pusattugasakhir.models;

public class logbook {
    String date;
    String progress;

    public logbook(String date, String progress){
        this.date = date;
        this.progress = progress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
