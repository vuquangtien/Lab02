package aims.main;

public class Utils {
    public static void showMenu() {
        System.out.println("\n\u001B[33m------------ AIMS MENU -------------");        
        System.out.println("Enter 1. View store");
        System.out.println("Enter 2. Update store");
        System.out.println("Enter 3. See current cart");
        System.out.println("Enter 4. Back up store");
        System.out.println("Enter 0. Exit");
        System.out.println("------------------------------------\u001B[37m");
    }

    public static void cartMenu() {
        System.out.println("\n\u001B[34m------------ VIEW CART -------------");
        System.out.println("Enter 1. Filter medias in cart");
        System.out.println("Enter 2. Sort medias in cart");
        System.out.println("Enter 3. Remove media from cart");
        System.out.println("Enter 4. Play a media");
        System.out.println("Enter 5. Place order");
        System.out.println("Enter 0. RETURN TO AIMS MENU");
        System.out.println("------------------------------------\u001B[37m");
    }

    public static void storeMenu() {
        System.out.println("\n\u001B[34m------------ VIEW STORE ------------");
        System.out.println("Enter 1. See a media's details");
        System.out.println("Enter 2. Add a media to cart");
        System.out.println("Enter 3. Play a media");
        System.out.println("Enter 4. See current cart");
        System.out.println("Enter 0. RETURN TO AIMS MENU");
        System.out.println("------------------------------------\u001B[37m");
    }

    public static void updateStoreMenu() {
        System.out.println("\n\u001B[34m----------- UPDATE STORE -----------");
        System.out.println("Enter 1. Add media to store");
        System.out.println("Enter 2. Remove media from store");
        System.out.println("Enter 0. RETURN TO AIMS MENU");
        System.out.println("------------------------------------\u001B[37m");
    }

    public static void addMediaMenu() {
        System.out.println("\n\u001B[33mADD MEDIA TO THE STORE\u001B[37m");
        System.out.println("   + Enter 1: Add CD to the Store");
        System.out.println("   + Enter 2: Add Book to the Store");
        System.out.println("   + Enter 3: Add DVD to the Store");
        System.out.println("   + Enter 0: RETURN TO UPDATE STORE");
    }

    public static void filterMenu() {
        System.out.println("\n\u001B[33mFILTER MEDIAS IN CART\u001B[37m");
        System.out.println("   + Enter 1: Filter by ID");
        System.out.println("   + Enter 2: Filter by title");
        System.out.println("   + Enter 0: RETURN TO VIEW CART");
    }

    public static void sortMenu() {
        System.out.println("\n\u001B[33mSORT MEDIAS IN CART\u001B[37m");
        System.out.println("   + Enter 1: Sort by ID");
        System.out.println("   + Enter 2: Sort by title");
        System.out.println("   + Enter 0: RETURN TO VIEW CART");
    }
}