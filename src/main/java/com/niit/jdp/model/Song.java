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
}
