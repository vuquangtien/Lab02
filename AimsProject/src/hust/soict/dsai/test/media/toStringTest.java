package hust.soict.dsai.test.media;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class toStringTest {
	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		// create some media here
		// for example: CD, DVD, book
		Media cd1 = new CompactDisc("director1", 12, "artist1" );
		Media dvd1 = new DigitalVideoDisc("DVD Title 1", "DVD Category", "director1", 120, 99.8f);
		Media book1 = new Book(123, "book1", "category1", 12.2f);
	
		mediae.add(cd1);
		mediae.add(dvd1);
		mediae.add(book1);
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
	}
}