package hust.soict.dsai.aims.store;
import java.util.*;
import hust.soict.dsai.aims.media.Media;

//Store
public class Store {
	public static final int maxqty = 100;
	private ArrayList<Media> itemsInStore = new
			ArrayList<Media>();
		
///add media to the cart
	public void addMedia(Media med) {
		if (itemsInStore.size() < maxqty) {
			itemsInStore.add(med);
			System.out.println("The media " + med.getTitle() + " has been added to the store");
		}else {System.out.println("The store is full");}
	}
//remove media from the cart
	public void removeMedia(Media med) {
		for (Media element : itemsInStore) {
            if (element == med) {
                itemsInStore.remove(med);
                System.out.println("The media " + med.getTitle() + " has been removed from the store");
            }else{System.out.println("The media is not in the store");}
        }
	}
//search for media	
	public Media search(String title) {
        for (Media med : itemsInStore) {
            if (med.getTitle().equals(title)) {
                return med;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
