/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 20-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.util.List;
import java.util.Objects;

public class Playlist {
    private int playlistId;
    private String playlistName;
    private List<Song> album;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, List<Song> album) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.album = album;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<Song> getAlbum() {
        return album;
    }

    public void setAlbum(List<Song> album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return playlistId == playlist.playlistId && Objects.equals(playlistName, playlist.playlistName) && Objects.equals(album, playlist.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, playlistName, album);
    }
}
