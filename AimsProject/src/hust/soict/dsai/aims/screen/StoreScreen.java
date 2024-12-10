package aims.screen;
import aims.cart.Cart;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import aims.media.Media;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
//	JMenuBar createMenuBar() {
//        JMenu menu = new JMenu("Options");
//
//        JMenu smUpdateStore = new JMenu("Update Store");
//        smUpdateStore.add(createMenuItem("Add Book", AddBookToStoreScreen.class));
//        smUpdateStore.add(createMenuItem("Add CD", AddCompactDiscToStoreScreen.class));
//        smUpdateStore.add(createMenuItem("Add DVD", AddDigitalVideoDiscToStoreScreen.class));
//
//        menu.add(smUpdateStore);
////        menu.add(createMenuItem("View store", ViewStoreScreen.class));
////        menu.add(createMenuItem("View cart", ViewCartScreen.class));
//        
//        
//        JMenuBar menuBar = new JMenuBar();
//        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
//        menuBar.add(menu);
//        
//        return menuBar;
//    }
	  JMenuBar createMenuBar() {
	  JMenu menu = new JMenu("Options");
	
	  JMenu smUpdateStore = new JMenu("Update Store");
	  
	  JMenuItem addBook = new JMenuItem("Add Book");
	  smUpdateStore.add(addBook);
	  addBook.addActionListener(new addBookListener());
	  
	  JMenuItem addCd = new JMenuItem("Add CD");
	  smUpdateStore.add(addCd);
	  addCd.addActionListener(new addCdListener());
	  
	  JMenuItem addDvd = new JMenuItem("Add DVD");
	  smUpdateStore.add(addDvd);
	  addDvd.addActionListener(new addDvdListener());
	
	  menu.add(smUpdateStore);
	  JMenuItem viewStore = new JMenuItem("View Store");
      menu.add(viewStore);
      JMenuItem viewCart= new JMenuItem("View Cart");
      menu.add(viewCart);
      viewCart.addActionListener(new viewCartListener());
	
	  JMenuBar menuBar = new JMenuBar();
	  menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	  menuBar.add(menu);
	
	  return menuBar;
	}
//    JMenuItem createMenuItem(String label, Class<? extends JFrame> frameClass) {
//        JMenuItem menuItem = new JMenuItem(label);
//        menuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    JFrame frame = frameClass.getDeclaredConstructor(Store.class, Cart.class).newInstance(store, cart);
//                    frame.setVisible(true);
//                    dispose(); // Close the current StoreScreen frame
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        return menuItem;
//    }
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.addActionListener(new viewCartListener());
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;	
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2 , 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < store.getItemsInStore().size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		
		return center;
		
	}
	protected class addBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddBookToStoreScreen(store);
        }
    }

	protected class addCdListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        }
    }

    protected class addDvdListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        }
    }
    
    private class viewCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new CartScreen(cart, store);
        }
    }
    //you are already view store so dont implement anymore
    
	public StoreScreen(Store store, Cart cart) {
		// TODO Auto-generated constructor stub
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		ArrayList<Media> mediae = new ArrayList<>();
	    CompactDisc cd = new CompactDisc(7,"SpiderMan","Action",null,123,305.5f);
	    DigitalVideoDisc dvd = new DigitalVideoDisc(0,"SlamDunk", "Animation","Inoue",120, 1563.6f );
	    Book book = new Book(8,"Dark", "Psychology", 55.6f);
	    Book book1 = new Book(9,"Light", "Psychology", 55.6f);
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"dvd1", "Animation","Inoue",120, 1563.6f );
	    DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"dvd2", "Bnimation","Inoue",120, 156.6f );
	    DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"dvd3", "Cnimation","Inoue",120, 163.6f );
	    DigitalVideoDisc dvd4 = new DigitalVideoDisc(4,"dvd4", "Dnimation","Inoue",120, 563.6f );
	    DigitalVideoDisc dvd5 = new DigitalVideoDisc(5,"dvd5", "Enimation","Inoue",120, 63.6f );
	    // Add some media objects to the list
	    mediae.add(cd);
	    mediae.add(dvd);
	    mediae.add(book);
	    mediae.add(book1);
	    mediae.add(dvd1);
	    mediae.add(dvd2);
	    mediae.add(dvd3);
	    mediae.add(dvd4);
	    mediae.add(dvd5);
	    
	    for (Media items: mediae) {
			store.addMedia(items);;
		}
		new StoreScreen(store, cart);
	}
}