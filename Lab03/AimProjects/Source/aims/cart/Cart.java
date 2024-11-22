package Lab03.AimProjects.Source.aims.cart;

import Lab03.AimProjects.Source.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBER_ODERED = 20;
    private DigitalVideoDisc itemsOrder[] = new DigitalVideoDisc[MAX_NUMBER_ODERED];
    private int qtyOrdered;

    public Cart(DigitalVideoDisc[] itemsOrder) {
        this.itemsOrder = itemsOrder;
        qtyOrdered = 0;
    }

    public Cart() {
        this.itemsOrder = new DigitalVideoDisc[MAX_NUMBER_ODERED];
        qtyOrdered = 0;
    }

    public void setItemsOrder(DigitalVideoDisc[] itemsOrder) {
        this.itemsOrder = itemsOrder;
    }

    public DigitalVideoDisc[] getItemsOrder() {
        return itemsOrder;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_NUMBER_ODERED) {
            itemsOrder[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList.length > MAX_NUMBER_ODERED - qtyOrdered) {
            System.out.println("There are not enough empty seat in cart");
        } else {
            for (int i = 0; i < dvdList.length; i++) {
                itemsOrder[qtyOrdered] = dvdList[i];
                qtyOrdered++;
            }
        }
    }


    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrder[i] == dvd) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrder[j] = itemsOrder[j + 1];
                    qtyOrdered--;
                }
                break;
            }
        }
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrder[i].getCost();
        }
        return sum;
    }

    public void listDVDs() {
        System.out.println("********************CART********************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrder[i].toString());
        }
        System.out.println("********************************************");
    }


    public void searchID(int id) {
        int count = 0;
        System.out.println("Searching result:");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrder[i].getID() == id) {
                System.out.println(itemsOrder[i].toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No result, try an other ID");
        }
    }

    public void searchName(String title) {
        int count = 0;
        System.out.println("Searching result:");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrder[i].isMatch(title)) {
                System.out.println(itemsOrder[i].toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No result, try another title");
        }
    }

}