/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 21-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service.database;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MusicPlayerService {
    public void play(Connection connection, String songPath) throws SQLException {

        int playlistID;
        try (Statement statement = connection.createStatement()) {
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println("Select playlist ID to play your song : ");
            playlistID = input.nextInt();
            statement.executeQuery("SELECT * FROM `playlist` WHERE playlist_id = '" + playlistID + "'");
        }
        if (playlistID == 1) {
            songPath = "src/main/resources/songs/Believer-Imagine-Dragons.wav";
        } else if (playlistID == 2) {
            songPath = "src/main/resources/songs/Dance-Monkey-Tones-And-I.wav";
        } else if (playlistID == 3) {
            songPath = "src/main/resources/songs/Umbrella-Rihanna.wav";
        } else if (playlistID == 4) {
            songPath = "src/main/resources/songs/Unstoppable-Sia.wav";
        } else if (playlistID == 5) {
            songPath = "src/main/resources/songs/Who-Says-Selena-Gomez.wav";
        } else if (playlistID == 6) {
            songPath = "src/main/resources/songs/Girls-Like-You-Maroon-5-Feat-Cardi-B.wav";
        } else if (playlistID == 7) {
            songPath = "src/main/resources/songs/Love-Yourself-Justin-Bieber.wav";
        } else if (playlistID == 8) {
            songPath = "src/main/resources/songs/Senorita-Camila-Cabello.wav";
        } else if (playlistID == 9) {
            songPath = "src/main/resources/songs/The-Weeknd-Blinding-Lights.wav";
        } else if (playlistID == 10) {
            songPath = "src/main/resources/songs/We-Dont-Talk-Anymore-Charlie-Puth-Feat-Selena-Gomez.wav";
        } else if (playlistID == 11) {
            songPath = "src/main/resources/songs/Lovely-Billie-Eilish.wav";
        } else if (playlistID == 12) {
            songPath = "src/main/resources/songs/Memories-Maroon-5.wav";
        } else if (playlistID == 13) {
            songPath = "src/main/resources/songs/Payphone-Maroon-5-Feat-Wiz-Khalifa.wav";
        } else if (playlistID == 14) {
            songPath = "src/main/resources/songs/Perfect-Ed-Sheeran.wav";
        } else if (playlistID == 15) {
            songPath = "src/main/resources/songs/What-Makes-You-Beautiful-Harry-Styles.wav";
        }
        File songFile = new File(songPath);
        try {
            // 3. an object of the AudioInputStream class
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            // 4. get a clip object from the AudioSystem
            Clip clip = AudioSystem.getClip();
            // 5. use the clip object to open the audio input stream
            clip.open(audioInputStream);
            // 6. set a loop for the sound file
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            // 7. start the sound file
            clip.start();
            // 8. pause the current thread for the time the song is being played
            long songDurationInMilliseconds = clip.getMicrosecondLength() / 1000L;
            Thread.sleep(songDurationInMilliseconds);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("song thread was interrupted");
        }
    }
}
