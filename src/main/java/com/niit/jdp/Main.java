package com.niit.jdp;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.service.database.DatabaseService;
import com.niit.jdp.service.database.MusicPlayerService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("Welcome to the JukeBox Catalogue");
            System.out.println("============================================");
            System.out.println("1. View all playlist");
            System.out.println("2. Search full song details by playlist ID");
            System.out.println("3: Create playlist using existing songs");
            System.out.println("4. Play song from playlist");
            System.out.println("5. Exit");
            System.out.println("============================================");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.connect();
                PlaylistRepository playlistRepository = new PlaylistRepository();
                Connection connection = databaseService.getConnection();

                switch (choice) {
                    case 1:

                        System.out.println("View all Playlist");
                        playlistRepository.displayPlaylistWithSongName(connection);
                        break;

                    case 2:

                        playlistRepository.displayPlaylistWithSongName(connection);
                        System.out.println("-------------------------------------------------------");
                        System.out.println("Enter Playlist ID to view full song details :");
                        int id = scanner.nextInt();
                        Playlist byId = playlistRepository.getById(connection, id);
                        if (byId.getPlaylistId() == 0) {
                            System.err.println("No salesperson found with the given ID");
                        } else {
                            System.out.println(byId);
                        }
                        break;

                    case 3:

                        System.out.println("Enter you're own Playlist Name : ");
                        String playlistName = scanner.next();
                        System.out.println("Your Playlist Name is created : " + playlistName);
                        System.out.println("Enter 1 to add song to your playlist : ");
                        int i = scanner.nextInt();
                        while (i == 1) {
                            System.out.println("Enter playlist ID to add into the playlist :");
                            int playlistID = scanner.nextInt();
                            playlistRepository.createPlaylist(connection, playlistID, playlistName);
                            System.out.println("Enter 2 to continue adding song to your playlist : ");
                            System.out.println("Enter 0 to stop adding :");
                            i = scanner.nextInt();
                        }
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("Viewing playlist to select ID");
                        System.out.println();
                        playlistRepository.displayPlaylistWithSongName(connection);
                        MusicPlayerService musicPlayerService = new MusicPlayerService();
                        String songPath = null;
                        musicPlayerService.play(connection, songPath);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            } catch (ClassNotFoundException | SQLException exception) {
                System.err.println("Could not connect to the database!");
                exception.printStackTrace();
                choice = 5;
            }
        } while (choice != 5);
    }
}