package aims.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import aims.cart.Cart;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Playable;
import aims.media.Track;
import aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);
    private static final String STORE_FILE = "AimsStore.txt";
    private static File file = new File("AimsProject/src/hust/soict/dsai/aims/store/" + STORE_FILE);
    private static String filePath = file.getAbsolutePath();
    private static final String DELIMITER = ";";

    public static void main(String[] args) {
        System.out.println(filePath);
        loadStore();

        Utils.showMenu();
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 4:
                    backupStore();
                    break;
                default:
                    System.out.println("\u001B[31m\nINVALID INPUT. PLEASE TRY AGAIN!\u001B[37m");
                    break;
                }
            
            Utils.showMenu();
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("\n\u001B[33m     THANK YOU, SEE YOU AGAIN!\n\u001B[37m");
    }

    // IMPLEMENT 1. VIEW STORE <seeMediaDetails(), addMediaToCart(), seeCurrentCart()>
    public static void viewStore() {
        store.showItems();
        Utils.storeMenu();
        System.out.print("Your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        while (choice != 0) {
            switch (choice) {
                case 1: 
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    // seeCurrentCart();
                    playMedia();
                    break;
                case 4:
                    cart.printOrder();
                    break;
                default:
                    System.out.println("\u001B[31m\nINVALID INPUT. PLEASE TRY AGAIN!\u001B[37m");
            }

            Utils.storeMenu();
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
        }
    }

    // 1.1 seeMediaDetails()
    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = sc.nextLine();
        Media media = store.search(title);

        if (media != null) {
            System.out.println(media.toString());
            System.out.print("Do you want to add this media '" + media.getTitle() + "' to the cart? (Y/N): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                cart.addMedia(media);
            } 
        } else {
            System.out.println("\u001B[31mCANNOT FOUND THE MEDIA '" + title + "' IN THE STORE!\u001B[37m");
        }
    }

    // 1.2 addMediaToCart()
    public static void addMediaToCart() {
        System.out.print("Enter the title of the media: ");
        String title = sc.nextLine();
        Media media = store.search(title);

        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("\u001B[31mCANNOT FOUND MEDIA '" + title + "' IN THE STORE!\u001B[37m");
        }
    }

    // 1.3 playMedia()
    public static void playMedia() {
        System.out.print("Enter the title of the media: ");
        String title = sc.nextLine();
        Media media = store.search(title);

        if (media != null && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
            ((Playable) media).play();
        } else {
            System.out.println("\u001B[31mMEDIA NOT FOUND OR CANNOT BE PLAYED!\u001B[37m");
        }
    }

    // 1.4 seeCurrentCart() or 3. seeCurrentCart()
    public static void seeCurrentCart() {
        cart.printOrder();
        Utils.cartMenu();
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    // filterMediasInCart()
                    filterMediasInCart();
                    break;
                case 2:
                    // sortMediasInCart()
                    sortMediasInCart();
                    break;
                case 3:
                    // removeMediaFromCart
                    removeMediaFromCart();
                    break;
                case 4:
                    // playMediaFromCart
                    playMediaFromCart();
                    break;
                case 5:
                    // placeOrder()
                    placeOrder(cart);
                    break;
                default:
                    System.out.println("\u001B[31m\nINVALID INPUT. PLEASE TRY AGAIN!");
                    break;
            }

            Utils.cartMenu();
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
        }
    }


    // IMPLEMENT 2. UPDATE STORE
    public static void updateStore() {
        Utils.updateStoreMenu();
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        while (choice != 0) {
            switch (choice) {
                case 1: 
                    addMediaToStore();
                    break;
                case 2: 
                    removeMediaFromStore();
                    break;
                default:
                    System.out.println("\u001B[31m\nINVALID INPUT. PLEASE TRY AGAIN!");
                    break;
            }

            Utils.updateStoreMenu();
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
        }
    }

    // 2.1 addMediaToStore() 
    public static void addMediaToStore() {
        while (true) {
            Utils.addMediaMenu();
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                // addCompactDisc()
                case 1:
                    System.out.println("\n\u001B[33mADD COMPACT DISC TO THE STORE\u001B[37m");
                    System.out.print("  + Enter the title   : ");
                    String cdTitle = sc.nextLine();

                    System.out.print("  + Enter the category: ");
                    String cdCategory = sc.nextLine();

                    System.out.print("  + Enter the cost    : ");
                    float cdCost = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("  + Enter the length  : ");
                    int cdLength = sc.nextInt();
                    sc.nextLine();

                    System.out.print("  + Enter the director: ");
                    String cdDirector = sc.nextLine();

                    System.out.print("  + Enter the artist  : ");
                    String cdArtist = sc.nextLine();

                    System.out.print("  + Enter the list of track titles <Separated by comma>: ");
                    String trackString = sc.nextLine();
                    List<String> trackTitles = new ArrayList<String>(Arrays.asList(trackString.split(",")));
                    
                    ArrayList<Track> cdTracks = new ArrayList<>();
                    for (String trackTitle : trackTitles) {
                        System.out.print("    + Enter the length of track '" + trackTitle + "': ");
                        int trackLength = sc.nextInt();
                        sc.nextLine();

                        Track track = new Track(trackTitle, trackLength);
                        cdTracks.add(track);
                    }
                    CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdCost, cdLength, cdDirector, cdArtist, cdTracks);
                    store.addMedia(cd);
                    break;
                
                // addBook()
                case 2:
                    System.out.println("\n\u001B[33mADD BOOK TO THE STORE\u001B[37m");
                    System.out.print("  + Enter the title   : ");
                    String bookTitle = sc.nextLine();

                    System.out.print("  + Enter the category: ");
                    String bookCategory = sc.nextLine();

                    System.out.print("  + Enter the cost    : ");
                    float bookCost = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("  + Enter the list of authors <Separate by comma>: ");
                    String authorString = sc.nextLine();
                    ArrayList<String> bookAuthors = new ArrayList<String>(Arrays.asList(authorString.split(",")));
                    
                    Book book = new Book(bookTitle, bookCategory, bookCost, bookAuthors);
                    store.addMedia(book);
                    break;

                // accDigitalVideoDisc()
                case 3: 
                    System.out.println("\n\u001B[33mADD COMPACT DISC TO THE STORE\u001B[37m");
                    System.out.print("  + Enter the title   : ");
                    String dvdTitle = sc.nextLine();

                    System.out.print("  + Enter the category: ");
                    String dvdCategory = sc.nextLine();

                    System.out.print("  + Enter the cost    : ");
                    float dvdCost = sc.nextFloat();
                    sc.nextLine();

                    System.out.print("  + Enter the length  : ");
                    int dvdLength = sc.nextInt();
                    sc.nextLine();

                    System.out.print("  + Enter the director: ");
                    String dvdDirector = sc.nextLine();

                    DigitalVideoDisc dvd = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdCost, dvdDirector, dvdLength);
                    store.addMedia(dvd);
                    break;
                case 0: 
                    break;
                default:
                    System.out.println("\u001B[31m\nINVALID INPUT. PLEASE TRY AGAIN!\u001B[37m\n");
                    break;
            }
            break;
        }
    }

    // 2.2 removeMediaFromStore() 
    public static void removeMediaFromStore() {
        System.out.print("Enter the title of the media to remove: ");
        String title = sc.nextLine();

        Media media = store.search(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("\n\u001B[31mThe media '" + title + "' is NOT EXIST in the Store!\u001B[37m");
        }
    }


    // IMPLEMENT 3. SEE THE CURRENT CART
    // 3.1 filterMediasInCart()
    public static void filterMediasInCart() {
        Utils.filterMenu();
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter media ID: ");
                int mediaID = sc.nextInt();
                sc.nextLine();
                cart.filterByID(mediaID);
                break;

            case 2:
                System.out.print("Enter media title: ");
                String mediaTitle = sc.nextLine();
                cart.filterByTitle(mediaTitle);
                break;

            case 0:
                break;
            
            default:
                System.out.println("\u001B[31m\nINVALID INPUT. PLEASE TRY AGAIN!\u001B[37m\n");
                break;
        }
    }

    // 3.2 sortMediasInCart
    public static void sortMediasInCart() {
        Utils.sortMenu();
        System.out.println("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                cart.sortMediaByCostTitle();
                break;
            case 2:
                cart.sortMediaByTitleCost();
                break;
            case 0:
                break;
            default:
                System.out.println("\u001B[31m\nINVALID INPUT. PLEASE TRY AGAIN!\u001B[37m");
                break;
        }
    }

    // 3.3 removeMediaFromCart
    public static void removeMediaFromCart() {
        System.out.print("Enter the title of the media to remove: ");
        String title = sc.nextLine();
        Media media = cart.search(title);

        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("\n\u001B[31mTHE MEDIA '" + title + "' IS NOT EXIST IN THE CART!\u001B[37m");
        }
    }

    // 3.4 playMediaFromCart() 
    public static void playMediaFromCart() {
        System.out.print("Enter the title of media to play: ");
        String title = sc.nextLine();
        Media media = cart.search(title);
        
        if (media != null && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
            ((Playable) media).play();
        } else {
            System.out.println("\n\u001B[31mMEDIA NOT FOUND OR CANNOT BE PLAYED!\u001B[37m");
        }
    }

    // 3.5 placeOrder() 
    public static void placeOrder(Cart cart) {
        System.out.print("Enter your name         : ");
        String customerName = sc.nextLine();

        System.out.print("Enter your phone number : ");
        String phoneNum = sc.nextLine();

        System.out.print("Enter your email        : ");
        String email = sc.nextLine();

        System.out.println("\n\u001B[32mYOUR ORDER IS CREATED SUCCESSFULLY!\n\u001B[37m");
        
        // printOrder() here
        System.out.println("\n\u001B[33m+------------------------------------------+");
        System.out.println("|                YOUR ORDER                |");
        System.out.println("+------------------------------------------+");
        System.out.println("| 1. INFORMATION:                          |");
        System.out.printf("|  - Name  : %-30s|\n", customerName);
        System.out.printf("|  - Phone : %-30s|\n", phoneNum);
        System.out.printf("|  - Email : %-30s|\n", email);
        System.out.println("+------------------------------------------+");
        System.out.println("| 2. ORDER DETAIL:                         |");
        for (Media media : cart.getItemOrdered() ) {
            String title = media.getTitle();
            String cost = String.format("%.2f", media.getCost());

            if (title.length() > 28) {
                title = title.substring(0, 26) + "..";
            }
            System.out.printf("|  - %-28s%7s $ |\n", title, cost);

        }
        System.out.println("|                                          |");
        String totalCost = String.format("%.2f", cart.getTotalCost());
        System.out.printf("|%32s%7s $ |\n", "Total Cost: ", totalCost);
        System.out.println("+------------------------------------------+\u001B[37m");

        cart.getItemOrdered().clear();
    }


    // IMPLEMENT 4. BACKUP STORE
    private static void backupStore() {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Media media : store.getItemsInStore()) {
                writer.println(mediaToString(media));
            }
            System.out.println("\n\u001B[32mSTORE BACKUP SUCCESSFULLY\u001B[37m");
        } catch (IOException e) {
            System.out.println("\n\u001B[31mERROR OCCURED WHILE BACKING UP STORE!\u001B[37m");
        }
    }

    private static String mediaToString(Media media) {
        String type = "";
        if (media instanceof Book) {
            type = "Book";
        }
        if (media instanceof CompactDisc) {
            type = "CD";
        }
        if (media instanceof DigitalVideoDisc) {
            type = "DVD";
        }
        return type + DELIMITER + media.toBackupString();
    }

    private static Media stringToMedia(String mediaString) {
        String[] tokens = mediaString.split(DELIMITER);

        String type = tokens[0];
        // int id = Integer.parseInt(tokens[1]);
        String title = tokens[2];
        String category = tokens[3];
        float cost = Float.parseFloat(tokens[4]);
        
        Media media = null;
        switch (type) {
            case "Book":
                // Convert String authorString to ArrayList<String> authors
                String authorString = tokens[5].substring(1, tokens[5].length()-1);
                String[] authorArray = authorString.split(", ");
                ArrayList<String> authors = new ArrayList<>(Arrays.asList(authorArray));
                media = new Book(title, category, cost, authors);
                break;

            case "CD":
                String cdDirector = tokens[5];
                int cdLength = Integer.parseInt(tokens[6]);
                String cdArtist = tokens[7];

                // Convert String trackString to ArrayList<Track> tracks
                String trackString = tokens[8].substring(1, tokens[8].length()-1);
                String[] trackArray = trackString.split(", ");
                ArrayList<Track> tracks = new ArrayList<>();
                for (String track : trackArray) {
                    String[] trackInfo = track.substring(1, track.length()-1).split("\\| ");
                    String trackTitle = trackInfo[0];
                    int trackLength = Integer.parseInt(trackInfo[1]);
                    tracks.add(new Track(trackTitle, trackLength));
                }

                media = new CompactDisc(title, category, cost, cdLength, cdDirector, cdArtist, tracks);
                break;
            case "DVD":
                String dvdDirector = tokens[5];
                int dvdLength = Integer.parseInt(tokens[6]);

                media = new DigitalVideoDisc(title, category, cost, dvdDirector, dvdLength);
                break;
            default:
                break;
        }
        return media;
    }

    private static void loadStore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Media media = stringToMedia(line);
                if (media != null) {
                    store.addMedia(media);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31mCANNOT FIND THE STORE FILE!\u001B[37m");
        } catch (IOException e) {
            System.out.println("\u001B[31mERROR OCCUR WHILE LOADING THE STORE!\u001B[37m");
        }
    }
}