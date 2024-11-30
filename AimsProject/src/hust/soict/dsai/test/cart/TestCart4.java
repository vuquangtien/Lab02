package test.cart;

import java.util.ArrayList;
import java.util.Scanner;

import aims.cart.Cart;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Track;

public class CartTest4 {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Media 1
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD Title 1", "DVD Category 1", 15.95f, "DVD Director 1", 120);
        
        // Media 2
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD Title 2", "DVD Category 1", 12.99f, "DVD Director 2", 90);
        
        // Media 3
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("DVD Title 3", "DVD Category 1", 145.25f, "DVD Director 3", 150);
    
        // Media 4
        ArrayList<Track> tracks = new ArrayList<>();
        Track track1 = new Track("Track1", 3);
        Track track2 = new Track("Track1", 4);
        tracks.add(track1);
        tracks.add(track2);
        CompactDisc cd1 = new CompactDisc("CD Title 1", "CD Category 1", 9.99f, 25, "CD Director 1", "Artist 1", tracks);
        Track track3 = new Track("Track 3", 6);
        cd1.addTrack(track3);

        // Media 5
        ArrayList<String> authors = new ArrayList<>();
        authors.add("Author 1");
        authors.add("Author 2");
        authors.add("Author 3");
        Book book1 = new Book("Book Title 1", "Book Category 1", 19.99f, authors);
        
        // Media 6
        Book book2 = new Book("Book Title 2", "Book Category 2", 1007.29f);
        book2.addAuthor("Author 4");
        book2.addAuthor("Author 5");
        book2.addAuthor("Author 4");
        book2.removeAuthor("Author 4");
        book2.removeAuthor("Author 2");


        System.out.println(book2.toString());

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(cd1);
        cart.addMedia(book1);
        cart.addMedia(book2);

        cart.printOrder();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name         : ");
        String customerName = sc.nextLine();

        System.out.print("Enter your phone number : ");
        String phoneNum = sc.nextLine();

        System.out.print("Enter your email        : ");
        String email = sc.nextLine();

        System.out.println("An order is created!");
        // printOrder() here

        System.out.println("\u001B[33m+------------------------------------------+");
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
            System.out.printf("|  - %-25s%10s $ |\n", title, cost);
            // System.out.printf("|  - %-13s                %-7.2f$ |\n", media.getTitle(), media.getCost());
        }

        System.out.println("|                                          |");

        String totalCost = String.format("%.2f", cart.getTotalCost());
        // System.out.printf("|                     Total Cost: %-7.2f$ |\n", cart.getTotalCost());

        System.out.printf("|%32s%7s $ |\n", "Total Cost: ", totalCost);
        System.out.println("+------------------------------------------+\u001B[37m");
        sc.close();
    }
}