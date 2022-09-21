/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 20-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    public List<Song> getAll(Connection connection) throws SQLException {

        String readQuery = "SELECT * FROM `jukebox`.`song`;";
        List<Song> songsList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet songsResultSet = statement.executeQuery(readQuery);
            while (songsResultSet.next()) {
                int serialNumber = songsResultSet.getInt("serial_number");
                String songName = songsResultSet.getString("song_name");
                LocalTime duration = songsResultSet.getTime("duration").toLocalTime();
                Song songs = new Song(serialNumber, songName, duration);
                songsList.add(songs);
            }
        }
        return songsList;
    }

    public LocalTime remainingDuration(Connection connection, LocalTime duration) {
        return null;
    }
}
