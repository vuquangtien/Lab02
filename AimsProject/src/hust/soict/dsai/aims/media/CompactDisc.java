package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
//Add fields
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	//Generate getter
	public String getArtist() {
		return artist;
	}
	public List<Track> getTracks() {
        return tracks;
    }
//Generate constructors
	public CompactDisc(String title, String director, int length, String artist) {
		super(director, length);
		this.artist = artist;
	}
	public CompactDisc(String title, String director, int length, List<Track> tracks) {
		super(director, length);
		this.tracks = tracks;
	}
	public CompactDisc(int id, String title, String category, String director, int length, String artist, List<Track> tracks, float cost) {
		super(director, length);
		this.artist = artist;
		this.tracks = tracks;
	}
//Create methods
	//add a track to the track list
	public void addTrack(Track newTrack) throws IllegalArgumentException {
		if (!tracks.contains(newTrack)) {
			tracks.add(newTrack);
			System.out.println("The track" + newTrack.getTitle() + "has been added");
		}else {
			throw new IllegalArgumentException(newTrack.getTitle() + "is already in the list");
		}
	}
	//remove a track from the track list
	public void removeTrack(Track inputTrack) throws NoSuchElementException {
        if (tracks.contains(inputTrack)) {
            tracks.remove(inputTrack);
            System.out.println("The track" + inputTrack.getTitle() + "has been removed from the list");
        }else{
        	throw new NoSuchElementException(inputTrack.getTitle() + "is not in the list");
        }
  
	}
	//get the CD's length
	public int getCDLength() {
		int CDLength = 0;
		for (int i=0; i<tracks.size(); i++) {
			CDLength += tracks.get(i).getLength();
		}return CDLength;
	}
//Add the play() method
	@Override
	public void play() throws PlayerException {
        if (getCDLength() > 0) {
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw new PlayerException("Cannot play track: " + nextTrack.getTitle(), e);
                }
            }
        } else {
            throw new PlayerException("Cannot play CD (CD's length is non-positive)");
        }
    }
	@Override
	public String toString() {
		return "CD - [" + title + 
				"] - [" + artist +
				"] - [" + category +
				"] - ["+ director +
				"] - [" + length + 
				"]: [" + cost + "$]";
	}
}
