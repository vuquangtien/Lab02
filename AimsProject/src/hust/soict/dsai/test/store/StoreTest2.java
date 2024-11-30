package test.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Track;

public class StoreTest2 {
    private static StoreTest store = new StoreTest();
    private static final String STORE_FILE = "AimsStore.txt";
    private static File file = new File("AimsProject/src/hust/soict/dsai/aims/store/" + STORE_FILE);
    private static String filePath = file.getAbsolutePath();
    private static final String DELIMITER = ";";
    public static void main(String[] args) {
        store.showItems();

        loadStore();
        store.showItems();
    }

    private static Media stringToMedia(String mediaString) {
        String[] tokens = mediaString.split(DELIMITER);

        String type = tokens[0];
        // int id = Integer.parseInt(tokens[1]);
        String title = tokens[2];
        String category = tokens[3];
        float cost = Float.parseFloat(tokens[4]);
        
        Media media = null;
        switch (type) {
            case "Book":
                // Convert String authorString to ArrayList<String> authors
                String authorString = tokens[5].substring(1, tokens[5].length()-1);
                String[] authorArray = authorString.split(", ");
                ArrayList<String> authors = new ArrayList<>(Arrays.asList(authorArray));
                media = new Book(title, category, cost, authors);
                break;

            case "CD":
                String cdDirector = tokens[5];
                int cdLength = Integer.parseInt(tokens[6]);
                String cdArtist = tokens[7];

                // Convert String trackString to ArrayList<Track> tracks
                String trackString = tokens[8].substring(1, tokens[8].length()-1);
                String[] trackArray = trackString.split(", ");
                ArrayList<Track> tracks = new ArrayList<>();
                for (String track : trackArray) {
                    String[] trackInfo = track.substring(1, track.length()-1).split("\\| ");
                    String trackTitle = trackInfo[0];
                    int trackLength = Integer.parseInt(trackInfo[1]);
                    tracks.add(new Track(trackTitle, trackLength));
                }

                media = new CompactDisc(title, category, cost, cdLength, cdDirector, cdArtist, tracks);
                break;
            case "DVD":
                String dvdDirector = tokens[5];
                int dvdLength = Integer.parseInt(tokens[6]);

                media = new DigitalVideoDisc(title, category, cost, dvdDirector, dvdLength);
                break;
            default:
                break;
        }
        return media;
    }

    private static void loadStore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Media media = stringToMedia(line);
                if (media != null) {
                    store.addMedia(media);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31mCANNOT FIND THE STORE FILE!\u001B[37m");
        } catch (IOException e) {
            System.out.println("\u001B[31mERROR OCCUR WHILE LOADING THE STORE!\u001B[37m");
        }
    }
}