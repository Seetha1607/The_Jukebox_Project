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
    private int playlistId;
    private String playlistName;
    private List<Song> songs;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, List<Song> songs) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songs = songs;
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return playlistId == playlist.playlistId && Objects.equals(playlistName, playlist.playlistName) && Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, playlistName, songs);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Playlist.class.getSimpleName() + "[", "]")
                .add("playlistId=" + playlistId)
                .add("playlistName='" + playlistName + "'")
                .add("songs=" + songs)
                .toString();
    }
}
