/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 20-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Playlist {
    private List<Album> album;

    public Playlist() {
    }

    public Playlist(List<Album> album) {
        this.album = album;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(album, playlist.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Playlist.class.getSimpleName() + "[", "]")
                .add("album=" + album)
                .toString();
    }
}
