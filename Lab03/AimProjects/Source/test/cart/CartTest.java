package Lab03.AimProjects.Source.test.cart;

import Lab03.AimProjects.Source.aims.cart.Cart;
import Lab03.AimProjects.Source.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();
        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);
        //Test the print method
        cart.listDVDs();
        //Test the search methods
        cart.searchID(2);
        cart.searchName("the lion king");

    }
}