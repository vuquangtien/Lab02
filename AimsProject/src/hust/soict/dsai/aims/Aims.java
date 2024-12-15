package hust.soict.dsai.aims;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import java.util.*;

//AIMS
public class Aims {
	public static Store store = new Store();
	public static Cart cart = new Cart();
    public static void main(String[] args) {

    }
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		Scanner scanner = new Scanner(System.in);
		int num_chosen = scanner.nextInt();
		scanner.nextLine();
		switch(num_chosen) {
			case 1:
				storeMenu(scanner);
				break;
			case 2:
				storeMenu(scanner);
				break;
			case 3:
				seeCurrentCart(scanner);
				break;
			case 0:
				System.out.println("Goodbye!");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
				showMenu();
				break;
		}
	}
	
	public static void storeMenu(Scanner scanner) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int num_chosen = scanner.nextInt();
        scanner.nextLine();

        switch (num_chosen) {
            case 1:
                seeMediaDetails(scanner);
                break;
            case 2:
                addMediaToCart(scanner);
                break;
            case 3:
                playMedia(scanner);
                break;
            case 4:
                seeCurrentCart(scanner);
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                storeMenu(scanner);
                break;
        }
    }
	
    public static void seeMediaDetails(Scanner scanner) {
    	System.out.println("Input the name of the media");
    	String title = scanner.nextLine();
    	Media med = store.search(title);
    	if (med == null) {
    		System.out.println("Cannot find the media!");
    	}else {System.out.println(med.toString());
    			mediaDetailMenu(scanner, med);}
    }
    
    public static void mediaDetailMenu(Scanner scanner, Media med) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (med instanceof CompactDisc || med instanceof DigitalVideoDisc) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int num_chosen = scanner.nextInt();
        scanner.nextLine();
        switch (num_chosen) {
            case 1:
                cart.addMedia(med);
                System.out.println("Media added to cart successfully!");
                break;
            case 2:
                if (med instanceof CompactDisc) {
                    ((CompactDisc) med).play();
                } else if (med instanceof DigitalVideoDisc) {
                    ((DigitalVideoDisc) med).play();}
                break;
            case 0:
                storeMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                mediaDetailMenu(scanner, med);
                break;
        }
    }
    
    public static void addMediaToCart(Scanner scanner) {
    	System.out.println("Enter the title of the media:");
    	String title = scanner.nextLine();
    	Media med = store.search(title);
    	if (med == null) {
    		System.out.println("Cannot find the Media!");  		
    	}else {cart.addMedia(med);
    			System.out.println("The media is added successfully");}
    }
    
    public static void playMedia(Scanner scanner) {
    	System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media med = store.search(title);
        if (med == null) {
            System.out.println("Cannot find the Media!");
        }else {
            if (med instanceof CompactDisc) {
                ((CompactDisc) med).play();
            }else if (med instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) med).play();}
        }
    }
    
	public static void seeCurrentCart(Scanner scanner) {
	    cart.printCart();
	    cartMenu(scanner);
	}
	
	public static void cartMenu(Scanner scanner) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		
		int num_chosen = scanner.nextInt();
        scanner.nextLine();
        switch (num_chosen) {
            case 1:
                filterMediaInCart(scanner);
                break;
            case 2:
                sortMediaInCart(scanner);
                break;
            case 3:
                removeMediaFromCart(scanner);
                break;
            case 4:
                playMediaOfCart(scanner);
                break;
            case 5:
                placeOrder(scanner);
                break;
            case 0:
                storeMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                cartMenu(scanner);
                break;
        }
	}
	
    public static void filterMediaInCart(Scanner scanner) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int num_chosen = scanner.nextInt();
        scanner.nextLine();
        switch (num_chosen) {
            case 1:
                System.out.println("Enter the ID of the media you want to filter:");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.search(id);
                break;
            case 2:
                System.out.println("Enter the title of the media you to filter:");
                String title = scanner.nextLine();
                cart.search(title);
                break;
            case 0:
                cartMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                filterMediaInCart(scanner);
                break;
        }
    }

    public static void sortMediaInCart(Scanner scanner) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int num_chosen = scanner.nextInt();
        scanner.nextLine();
        switch (num_chosen) {
            case 1:
                Collections.sort(cart.getItemsOrdered(), new MediaComparatorByTitleCost());
                break;
            case 2:
                Collections.sort(cart.getItemsOrdered(), new MediaComparatorByCostTitle());
                break;
            case 0:
                cartMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                sortMediaInCart(scanner);
                break;
        }
    }

    public static void removeMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media you want to remove:");
        String title = scanner.nextLine();   
        Media mediaToRemove = null;
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equals(title)) {
                mediaToRemove = media;
                break;
            }
        }if (mediaToRemove != null) {
            cart.removeMedia(mediaToRemove);
            System.out.println(
            		"The media " + mediaToRemove.getTitle() + " has been removed from the cart.");
        }else {System.out.println("The media "+ title + " is not in the cart.");}
    }
    
    public static void playMediaOfCart(Scanner scanner) {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = cart.search(title);
        if (media == null) {
            System.out.println("Cannot find the media!");
        }else {
            if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            }else if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();}
        }cartMenu(scanner);
    }

    public static void placeOrder(Scanner scanner) {
        if (cart.getNumberOfItems() == 0) {
            System.out.println("The cart is empty. Cannot place any order");
        }else {System.out.println("Order placed successfully!");
               cart.clearCart();}
        cartMenu(scanner);
    }
}
