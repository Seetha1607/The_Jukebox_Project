package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.database.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class SongRepositoryTest {
    SongRepository songRepository = null;
    Song song;
    DatabaseService databaseService = new DatabaseService();
    Connection connection = databaseService.getConnection();


    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        songRepository = new SongRepository();
        song = new Song();
        databaseService = new DatabaseService();

    }

    @AfterEach
    void tearDown() {
        songRepository = null;
        song = null;
    }


    @Test
    void getSongByIdSuccess() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song output = songRepository.getById(connection, song.getSongId());
        Song expectedOutput = songRepository.getById(connection, output.getSongId());
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    void getSongByIdFailure() throws SQLException, ClassNotFoundException {
        databaseService.connect();
        Connection connection = databaseService.getConnection();
        Song output = songRepository.getById(connection, 10);
        boolean expectedOutput = songRepository.deleteById(connection, song.getSongId());
        Assertions.assertNotEquals(expectedOutput, output);
    }

}