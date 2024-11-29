package aims.store;

import java.util.ArrayList;

import aims.media.Media;

public class Store {
    
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media '" + media.getTitle() + "' has been ADDED to the Store!");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media '" + media.getTitle() + "' has been REMOVED from the Store!");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is not in the store");
        }
    }

    public void showItems() {
        System.out.println("************************STORE************************");
        int i = 0;
        for (Media media : itemsInStore) {
            System.out.printf("%d. ID: %d, %s\n",i+1,media.getId(), media.getDetail());
        }
        System.out.println("*****************************************************");
    }
}