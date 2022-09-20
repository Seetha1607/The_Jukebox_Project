/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 20-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.util.List;

public class Album {
    private String nameOfAlbum;
    private String genreOfAlbum;
    private List<Song> songs;

    public Album() {
    }

    public Album(String nameOfAlbum, String genreOfAlbum, List<Song> songs) {
        this.nameOfAlbum = nameOfAlbum;
        this.genreOfAlbum = genreOfAlbum;
        this.songs = songs;
    }

    public String getNameOfAlbum() {
        return nameOfAlbum;
    }

    public void setNameOfAlbum(String nameOfAlbum) {
        this.nameOfAlbum = nameOfAlbum;
    }

    public String getGenreOfAlbum() {
        return genreOfAlbum;
    }

    public void setGenreOfAlbum(String genreOfAlbum) {
        this.genreOfAlbum = genreOfAlbum;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
