/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 20-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.time.LocalTime;

public class Song {
    private int serialNumber;
    private String songName;
    private LocalTime duration;

    public Song() {
    }

    public Song(int serialNumber, String songName, LocalTime duration) {
        this.serialNumber = serialNumber;
        this.songName = songName;
        this.duration = duration;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
