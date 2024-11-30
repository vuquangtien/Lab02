package store;

import aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("\u001B[32mTHE MEDIA '" + media.getTitle() + "' HAS BEEN ADDED TO THE STORE!\u001B[37m");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("\u001B[32mTHE MEDIA '" + media.getTitle() + "' HAS BEEN REMOVED FROM THE STORE!\u001B[37m");
        } else {
            System.out.println("\u001B[31mTHE MEDIA '" + media.getTitle() + "' IS NOT EXIST IN THE STORE!\u001B[37m");
        }
    }

    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void showItems() {
        // System.out.println("\n\u001B[33m------------------ STORE ITEMS ------------------");
        // if (itemsInStore.size() == 0) {
        //     System.out.println("             <Your store is empty!>");
        // }
        // int i = 0;
        // for (Media media : itemsInStore) {
        //     System.out.printf("%d. %s\n",i+1, media.getDetail());
        //     i += 1;
        // }
        // System.out.println("-------------------------------------------------\n\u001B[37m");

        System.out.println("\n\u001B[33m+----------------------------------------------------------------+");
        System.out.println("|                          STORE ITEMS                           |");
        System.out.println("+----+--------+--------------------------+------------+----------+");
        System.out.println("| No.|   ID   |         Title            |  Category  |   Cost   |");
        System.out.println("+----+--------+--------------------------+------------+----------+");
        if (itemsInStore.size() == 0) {
            System.out.println("|                    < Your store is empty!>                     |");
            System.out.println("+----------------------------------------------------------------+");
        } else {
            int index = 0;
            for (Media media : itemsInStore) {
                int id = media.getId();
                String title = media.getTitle();
                if (title.length() > 24) {
                    title = title.substring(0, 22) + "..";
                }
                String category = media.getCategory();
                if (category.length() > 10) {
                    category = category.substring(0, 8) + "..";
                }
                float cost = media.getCost();
                index += 1;
                System.out.printf("| %-2s | %-6s | %-24s | %-10s |  %5s$  |\n", index, id, title, category, cost);
                // System.out.println("+----+--------+--------------------------+------------+----------+");


            }
            System.out.println("+----+--------+--------------------------+------------+----------+\u001B[37m");
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}

/*
A123456789B123456789C123456789D123456789E123456789F123456789G12345
+----------------------------------------------------------------+
|                          STORE ITEMS                           |
+----+--------+--------------------------+------------+----------+
| No.|   ID   |         Title            |  Category  |   Cost   |
+----+--------+--------------------------+------------+----------+
| 9  | 100009 | To Kill a Mocking Bird   |  Fiction   |  15.99$  |
+----+--------+--------------------------+------------+----------+
| 10 | 100003 | Harry Potter and the P.. |  Fantasy   |  12.99$  |
+----+--------+--------------------------+------------+----------+
| 6  | 100006 | Java: A Beginner's Guide | Programm.. |  19.99$  |
+----+--------+--------------------------+------------+----------+
*/