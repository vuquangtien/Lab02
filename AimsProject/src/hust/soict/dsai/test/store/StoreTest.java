package test.store;

import aims.media.DigitalVideoDisc;
import aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Add DVDs to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars: A New Hope", 
            "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter and the Philosopher's Stone", 
            "Fantasy", "Chris Columbus", 152, 27.98f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", 
            "Animation", 18.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avatar 2", 
            "Sci-fi/Action", "Jame Cameron", 190, 26.4f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);
        store.addDVD(dvd5);

        store.removedDVD(dvd2);
        store.showItems();
    }
}