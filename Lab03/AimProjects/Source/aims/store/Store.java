package Lab03.AimProjects.Source.aims.store;

import Lab03.AimProjects.Source.aims.disc.DigitalVideoDisc;

public class Store {
    public static int MAX_ITEMS_IN_STORE = 200;
    private DigitalVideoDisc[] itemInstore;
    private int qtyOrdered = 0;

    public Store(DigitalVideoDisc itemInStrore[]) {
        this.itemInstore = itemInStrore;
    }

    public Store() {
        itemInstore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_ITEMS_IN_STORE) {
            itemInstore[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The store is almost full");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemInstore[i].equals(dvd)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemInstore[j] = itemInstore[j + 1];
                }
                qtyOrdered--;
                break;
            }
        }
    }

    public void displayAllDVDs() {
        System.out.println("******************STORE*****************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemInstore[i].toString());
        }
        System.out.println("****************************************");
    }

}
