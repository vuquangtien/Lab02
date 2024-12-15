package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class StoreScreen extends JFrame{
    private Store store;

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Option");

        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
        	AddBookToStoreScreen addBookToScreen = new AddBookToStoreScreen(store);
        	addBookToScreen.showScreen();
        });
        
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
        	AddCompactDiscToStoreScreen addCDToScreen = new AddCompactDiscToStoreScreen(store);
        	addCDToScreen.showScreen();
        });
        
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
        	AddDigitalVideoDiscToStoreScreen addDVDToScreen = new AddDigitalVideoDiscToStoreScreen(store);
        	addDVDToScreen.showScreen();
        });
        
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);
        
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i), store);
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
    
    public static void main(String[] args){
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(123, "title1", "category1", "diretor1", 150, 9.81f);
		Book book1 = new Book(135, "title2", "category2", 22f);
		CompactDisc cd1 = new CompactDisc("title3", "director3", 90, "artist");
		
		store.addMedia(dvd1);
		store.addMedia(book1);
		store.addMedia(cd1);
		
		new StoreScreen(store);
	}
}
