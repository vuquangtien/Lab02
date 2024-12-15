package hust.soict.dsai.test.media;
import hust.soict.dsai.aims.media.*;

import java.util.*;

public class SortingTest {
    public static void main(String[] args) {
        List<Media> collection = new ArrayList<>();

        Media cd1 = new CompactDisc("director1", 12, "artist1" );
        collection.add(cd1);
        
		Media dvd1 = new DigitalVideoDisc("DVD Title 1", "DVD Category", "director1", 120, 99.8f);
		collection.add(dvd1);
		
		Media book1 = new Book(123, "book1", "category1", 12.2f);
		collection.add(book1);
		
        Collections.sort(collection, new MediaComparatorByCostTitle());
        
        for (Media media : collection) {
            System.out.println(media.toString());
        }
    }
}