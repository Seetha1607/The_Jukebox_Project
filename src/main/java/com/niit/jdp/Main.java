package com.niit.jdp;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.database.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("Welcome to the JukeBox Catalogue");
            System.out.println("============================================");
            System.out.println("1. View all playlist");
            System.out.println("2. Create playlist");
            System.out.println("3: View all Songs from playlist");
            System.out.println("4. Play song from playlist");
            System.out.println("5. Exit");
            System.out.println("============================================");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.connect();
                databaseService.printConnectionStatus();
                SongRepository songRepository = new SongRepository();
                PlaylistRepository playlistRepository = new PlaylistRepository();
                Connection connection = databaseService.getConnection();

                switch (choice) {
                    case 1:

                        System.out.println("View all Playlist");
                        List<Playlist> all = playlistRepository.getAll(connection);
                        System.out.println("all = " + all);

                        System.out.println("Enter id:");
                        int id = scanner.nextInt();
                        Playlist byId = playlistRepository.getById(connection, id);
                        if (byId.getPlaylistId() == 0) {
                            System.err.println("No salesperson found with the given ID");
                        } else {
                            System.out.println(byId);
                        }
                        break;

                    case 2:

                        //System.out.println("Enter playlist id to create you're own playlist : ");
                        //int ownPlaylist = scanner.nextInt();
                        //Song song = new Song(ownPlaylist, "Naan Pizhai", "Vignesh Shivan", "Melody", "00.04.45","src/main/resources/songs/naan-pizhai-kaathuvaakula-rendu-kaadhal-128-kbps-sound.wav");
                        //songRepository.add(connection,song);
                        //System.out.println("song = " + song);
                        boolean b = songRepository.deleteById(connection, 16);
                        System.out.println("b = " + b);


                        break;

                    case 3:

                        System.out.println("View all Songs from Playlist");
                        songRepository.getAll(connection).forEach(System.out::println);
                        break;

                }
            } catch (ClassNotFoundException | SQLException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
                choice = 5;
            }
        } while (choice != 5);
    }
}