/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 20-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {

    public boolean createPlaylist(Connection connection, int playlistID, String playlist_name) throws SQLException {

        String insertQuery = "INSERT INTO `jukebox`.`playlist` ('playlist ID`,`playlist_Name`) VALUES ('" + playlistID + "','" + playlist_name + "')";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    public List<Playlist> getAll(Connection connection) throws SQLException {
        String readQuery = "SELECT * FROM `jukebox`.`playlist`;";
        List<Song> songList = new SongRepository().getAll(connection);
        List<Song> songs = new ArrayList<>();
        List<Playlist> playlist = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet playlistResultSet = statement.executeQuery(readQuery);
            while (playlistResultSet.next()) {
                int playlistId = playlistResultSet.getInt("playlist_id");
                String playlistName = playlistResultSet.getString("playlist_name");
                int songNumber = playlistResultSet.getInt("songs");
                Song songId = songList.get(songNumber - 1);
                songs.add(songId);
                Playlist playlist1 = new Playlist(playlistId, playlistName, songs);
                playlist.add(playlist1);
            }
            return playlist;
        }
    }


    public Playlist getById(Connection connection, int id) throws SQLException {
        String searchQuery = "SELECT * FROM `jukebox`.`playlist` WHERE(`playlist_id` = ?);";
        List<Song> songList = new SongRepository().getAll(connection);
        List<Song> songs = new ArrayList<>();
        Playlist playlist = new Playlist();
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet playlistResultSet = preparedStatement.executeQuery();
            while (playlistResultSet.next()) {
                int playlistId = playlistResultSet.getInt("playlist_id");
                String playlistName = playlistResultSet.getString("playlist_name");
                int songNumber = playlistResultSet.getInt("songs");
                Song songId = songList.get(songNumber - 1);
                songs.add(songId);
                playlist = new Playlist(playlistId, playlistName, songs);
            }
        }
        return playlist;
    }


    public boolean deleteById(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM `jukebox`.`playlist` WHERE (`playlist_id` = ?);";
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        return numberOfRowsAffected > 0;
    }

    public void displayPlaylistWithSongName(Connection connection) throws SQLException {
        String readQuery = "SELECT playlist.playlist_id AS 'Playlist ID',\n" + "       playlist.playlist_name AS 'Playlist Name',\n" + "       song.song_name AS 'Song Name'\n" + "       FROM playlist\n" + "       JOIN song ON (song.song_id = playlist.songs);";

        ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(readQuery);
        }
        while (resultSet.next()) {
            System.out.printf("%s  %s  %s", "Playlist ID " + resultSet.getInt(1) + " ", "Playlist Name  " + resultSet.getString(2) + " ", "Song Name  " + resultSet.getString(3));
            System.out.println();
        }
    }
}