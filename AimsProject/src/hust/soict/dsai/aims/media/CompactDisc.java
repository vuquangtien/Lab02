package aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("\u001B[31mTHE TRACK IS ALREADY IN THE LIST OF TRACKS!\u001B[37m");
        } else {
            tracks.add(track);
            System.out.println("\u001B[32mTHE TRACK '" + track.getTitle() + "' HAS BEEN ADDED TO THE LIST OF TRACKS!\u001B[37m");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("\u001B[35mTHE TRACK '" + track.getTitle() + "' HAS BEEN REMOVED FROM THE LIST OF TRACK!\u001B[37m");
        } else {
            System.out.println("\u001B[31mTHE TRACK IS NOT EXIST IN THE LIST OF TRACKS!\u001B[37m");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("\n\u001B[33mPLAY THE MEDIA\u001B[37m");
        System.out.println(" - Playing Compact Disc : " + getTitle());
        System.out.println(" - Director             : " + getDirector());
        System.out.println(" - Length               : " + getLength() + " minutes");

        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        // return "CompactDisc [id=" + id + ", title=" + title + ", category=" 
        //     + category + ", cost=" + cost + ", director= " + director + ", length=" 
        //     + length + ", artist=" + artist + ", tracks=" + tracks.toString() + "]";
        return "\n\u001B[33m--------- COMPARC DISC ---------\n\u001B[37m" + 
               " - ID      : " + id + "\n" + 
               " - Title   : " + title + "\n" + 
               " - Category: " + category + "\n" + 
               " - Cost    : " + cost + "\n" + 
               " - Director: " + director + "\n" + 
               " - Length  : " + length + "\n" + 
               " - Artist  : " + artist + "\n" + 
               " - Tracks  : " + tracks.toString() + "\n" + 
               "--------------------------------\n";
    }

    public String toBackupString() {
        return id + "," + title + "," + category + "," + cost + "," + director + "," + length + "," + artist + "," + tracks.toString();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
}