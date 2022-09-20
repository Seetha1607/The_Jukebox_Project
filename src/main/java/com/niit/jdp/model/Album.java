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
}
