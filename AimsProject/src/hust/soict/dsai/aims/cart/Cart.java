package aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import aims.media.Media;

public class Cart {

    private ArrayList<Media> itemsOrdered;

    public Cart() {
        itemsOrdered = new ArrayList<>();
    }

    public void sortMediaByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }  

    public void sortMediaByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void filterByID(int mediaID) {
        ArrayList<Media> filteredList = new ArrayList<>();

        for (Media media : itemsOrdered) {
            if (media.getId() == mediaID) {
                filteredList.add(media);
            }
        }

        if (filteredList.isEmpty()) {
            System.out.println("\u001B[31mNO MEDIA FOUND WITH THE ID '" + mediaID + "'\u001B[37m");
        } else {
            System.out.println("\u001B[31mFILTERED MEDIA LIST WITH THE ID '" + mediaID + "'\u001B[31m");
        }
    }

    public void filterByTitle(String mediaTitle) {
        ArrayList<Media> filteredList = new ArrayList<>();

        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(mediaTitle)) {
                filteredList.add(media);
            }
        }

        if (filteredList.isEmpty()) {
            System.out.println("\u001B[31mNO MEDIA FOUND WITH THE ID '" + mediaTitle + "'\u001B[37m");
        } else {
            System.out.println("\u001B[31mFILTERED MEDIA LIST WITH THE ID '" + mediaTitle + "'\u001B[31m");
        }
    }

    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("\u001B[32mTHE MEIDA '" + media.getTitle() + "' HAS BEEN ADDED TO THE CART!\u001B[0m");
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("\u001B[32mTHE MEIDA '" + media.getTitle() + "' HAS BEEN REMOVED FROM THE CART!\u001B[0m");
        } else {
            System.out.println("\u001B[31mTHE MEIDA '" + media.getTitle() + "' IS NOT EXIST IN THE CART!\u001B[0m");
        }
    }

    public float getTotalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public ArrayList<Media> getItemOrdered() {
        return itemsOrdered;
    }

    public Media search(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void printOrder() {
        
        System.out.println("\n\u001B[33m------------------ CART ITEMS -------------------");
        if (itemsOrdered.size() == 0) {
            System.out.println("             <Your cart is empty!>");
        } else {
            System.out.println("Ordered Items: ");
        }

        int i = 0;
        for (Media media : itemsOrdered) {
            System.out.printf("%d. %s\n",i+1, media.getDetail());     
            i += 1;
        }

        System.out.printf("Total cost: %.2f$\n", getTotalCost());
        System.out.println("-------------------------------------------------\n\u001B[37m");
    }
}