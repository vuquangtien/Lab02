package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.naming.LimitExceededExeption;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("CART");
		this.setVisible(true);
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/screen/fxml/cart.fxml"));
					CartScreenController controller = 
							new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) throws LimitExceededExeption{
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(123, "title1", "category1", "diretor1", 150, 9.81f);
		Book book1 = new Book(135, "title2", "category2", 22f);
		
		cart.addMedia(dvd1);
		cart.addMedia(book1);
		
		new CartScreen(cart);
	}
}
