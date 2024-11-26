package aims.cart;

import aims.disc.DigitalVideoDisc;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full!");
            return;
        }
        itemsOrdered[qtyOrdered++] = disc;
        System.out.println("The disc has been added");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc was not found in the cart");
    }

    public float getTotalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void searchByTitle(String title) {
        int count = 0;
        
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].search(title)) {
                System.out.println(itemsOrdered[i].toString());
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println("No match found for title = '" + title + "'!");
        }
    }

    public void searchByID(int id) {
        boolean found = false;
        for (int i = 0; i< qtyOrdered; i++) {
            if (itemsOrdered[i].getID() == id) {
                System.out.println(itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for id = '" + id + "'!");
        }
    }

    public void printOrder() {
        
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items: ");

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.printf("%d. %s\n",i+1, dvd.getDetail());
            
        }

        System.out.printf("Total cost: %.2f\n", getTotalCost());
        System.out.println("***************************************************");
    }
}