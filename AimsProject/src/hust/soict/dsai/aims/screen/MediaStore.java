package aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;

import aims.cart.Cart;
import aims.media.Media;
import aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private JButton btnAddCart, btnPlay;
	private Cart cart;
	
	public MediaStore(Media media, Cart cart) {
		ButtonListener btnListener = new ButtonListener();
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);;
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		container.add(btnAddCart = new JButton("Add to cart"));
		if (media instanceof Playable) {
			container.add(btnPlay = new JButton("Play"));
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnAddCart.addActionListener(btnListener);
		if (btnPlay != null) {
            btnPlay.addActionListener(btnListener);
        }
	}
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("Add to cart")) {
				// Add media to the cart
	            try {
					cart.addMedia(media);
				} catch (LimitExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            System.out.println("Added to cart: " + media.getTitle());
	         // Show a dialog to announce that the item has been successfully added to the cart
                JOptionPane.showMessageDialog(null, "Item added to cart: " + media.getTitle(), "Add to Cart",
                        JOptionPane.INFORMATION_MESSAGE);
				
			}
			else if (button.equals("Play")) {
				// Play the media in a dialog window
	            JDialog dialog = new JDialog();
	            dialog.setTitle("Play Media");
	            dialog.setSize(400, 300);
	            dialog.setLocationRelativeTo(null);
	            
	            // Create a JLabel to display the media title
	            JLabel titleLabel = new JLabel(media.getTitle());
	            titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
	            titleLabel.setHorizontalAlignment(JLabel.CENTER);
	            
	            // Add the label to the dialog
	            dialog.getContentPane().add(titleLabel, BorderLayout.CENTER);
	            
	            // Set the dialog visible
	            dialog.setVisible(true);
			}
		}
	}

}