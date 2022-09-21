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
    private int songId;
    private String songName;
    private LocalTime duration;

    public Song() {
    }

    public Song(int songId, String songName, LocalTime duration) {
        this.songId = songId;
        this.songName = songName;
        this.duration = duration;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
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
        return songId == song.songId && Objects.equals(songName, song.songName) && Objects.equals(duration, song.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, songName, duration);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Song.class.getSimpleName() + "[", "]")
                .add("songId=" + songId)
                .add("songName='" + songName + "'")
                .add("duration=" + duration)
                .toString();
    }
}