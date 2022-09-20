/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 20-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.time.LocalTime;
import java.util.Objects;
import java.util.StringJoiner;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return serialNumber == song.serialNumber && Objects.equals(songName, song.songName) && Objects.equals(duration, song.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, songName, duration);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Song.class.getSimpleName() + "[", "]")
                .add("serialNumber=" + serialNumber)
                .add("songName='" + songName + "'")
                .add("duration=" + duration)
                .toString();
    }
}
