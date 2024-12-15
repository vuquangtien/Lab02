package hust.soict.dsai.aims.media;

public class Track implements Playable {
//Add fields
	private String title;
	private int length;
//Generate getter 
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
//Generate constructors
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
//Add the play() method
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
//Override the equals method
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Track myTrack = (Track) obj;
		return this.title.equals(myTrack.getTitle()) 
				&& this.length == myTrack.length;
	}
}
