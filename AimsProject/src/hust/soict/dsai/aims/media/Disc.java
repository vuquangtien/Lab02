package hust.soict.dsai.aims.media;

public class Disc extends Media{
//Add fields
	protected String director;
	protected int length;
//Generate getter and setter
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
//Generate constructors
	public Disc(String director, int length) {
		super();
		this.director = director;
		this.length = length;
	}
	public Disc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Disc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	public Disc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public Disc() {
		// TODO Auto-generated constructor stub
	}	
}
