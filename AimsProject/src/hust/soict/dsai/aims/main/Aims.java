package aims.main;

import aims.cart.Cart;
import aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.print("Total Cost is: ");
        System.out.println(anOrder.getTotalCost());

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar 2", "Sci-fi/Action", "Jame Cameron", 190, 26.4f);
        anOrder.addDigitalVideoDisc(dvd4);
        System.out.println("Total Cost is: " + anOrder.getTotalCost());

        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost is: " + anOrder.getTotalCost());

        anOrder.printOrder();
        anOrder.searchByTitle("king");

    }
}