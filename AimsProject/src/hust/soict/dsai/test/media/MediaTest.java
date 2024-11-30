package test.media;

import java.util.ArrayList;

import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Track;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> medias = new ArrayList<>();
        
        // Media 1
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD Title 1", "DVD Category 1", 15.95f, "DVD Director 1", 120);
        
        // Media 2
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD Title 2", "DVD Category 1", 12.99f, "DVD Director 2", 90);
        
        // Media 3
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("DVD Title 3", "DVD Category 1", 145.25f, "DVD Director 3", 150);
    
        // Media 4
        ArrayList<Track> tracks = new ArrayList<>();
        Track track1 = new Track("Track1", 3);
        Track track2 = new Track("Track1", 4);
        tracks.add(track1);
        tracks.add(track2);
        CompactDisc cd1 = new CompactDisc("CD Title 1", "CD Category 1", 9.99f, 25, "CD Director 1", "Artist 1", tracks);
        Track track3 = new Track("Track 3", 6);
        cd1.addTrack(track3);

        // Media 5
        ArrayList<String> authors = new ArrayList<>();
        authors.add("Author 1");
        authors.add("Author 2");
        authors.add("Author 3");
        Book book1 = new Book("Book Title 1", "Book Category 1", 19.99f, authors);
        
        // Media 6
        Book book2 = new Book("Book Title 2", "Book Category 2", 1007.29f);
        book2.addAuthor("Author 4");
        book2.addAuthor("Author 5");
        book2.addAuthor("Author 4");
        book2.removeAuthor("Author 4");
        book2.removeAuthor("Author 2");

        medias.add(dvd1);
        medias.add(dvd2);
        medias.add(dvd3);
        medias.add(book1);
        medias.add(cd1);
        medias.add(book2);

        System.out.println(dvd1.toString());
        System.out.println(book1.toString());
        System.out.println(cd1.toString());

        for (Media media : medias) {
            System.out.println(media.toBackupString());
        }
    }
}