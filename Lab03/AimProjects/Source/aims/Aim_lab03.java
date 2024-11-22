package Lab03.AimProjects.Source.aims;

import Lab03.AimProjects.Source.aims.cart.Cart;
import Lab03.AimProjects.Source.aims.disc.DigitalVideoDisc;

public class Aim_lab03 {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);

        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geogre Lucas", 87, 24.95f);

        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);
        anOrder.listDVDs();

    }

}