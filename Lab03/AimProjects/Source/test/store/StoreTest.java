package Lab03.AimProjects.Source.test.store;

import Lab03.AimProjects.Source.aims.disc.DigitalVideoDisc;
import Lab03.AimProjects.Source.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        //Create a new cart
        Store store = new Store();
        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        store.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addDVD(dvd3);

        store.displayAllDVDs();

        store.removeDVD(dvd2);

        store.displayAllDVDs();

    }
}