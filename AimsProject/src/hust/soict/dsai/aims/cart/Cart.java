package aims.cart;

import aims.media.Media;
import java.util.ArrayList;

public class Cart {

    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("The media '" + media.getTitle() + "' has been add successfully");
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media '" + media.getTitle() + "' has been remove successfully");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is not exist in the cart");
        }
    }

    public float getTotalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // public void searchByTitle(String title) {
    //     int count = 0;
        
    //     for (Media media : itemsOrdered) {
    //         if (media.search(title)) {
    //             System.out.println(media.toString());
    //             count = count + 1;
    //         }
    //     }
    //     if (count == 0) {
    //         System.out.println("No match found for title = '" + title + "'!");
    //     }
    // }

    // public void searchByID(int id) {
    //     boolean found = false;
    //     for (int i = 0; i< qtyOrdered; i++) {
    //         if (itemsOrdered[i].getId() == id) {
    //             System.out.println(itemsOrdered[i].toString());
    //             found = true;
    //         }
    //     }
    //     if (!found) {
    //         System.out.println("No match found for id = '" + id + "'!");
    //     }
    // }

    public void printOrder() {
        
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items: ");

        int i = 0;
        for (Media media : itemsOrdered) {
            System.out.printf("%d. %s\n",i+1, media.getDetail());     
        }

        System.out.printf("Total cost: %.2f\n", getTotalCost());
        System.out.println("***************************************************");
    }
}