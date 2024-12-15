package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    
    public MediaStore(Media media, Store store){

        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		store.addMedia(media);
        		System.out.println("Added to cart: " + media.getTitle());
        	}
        });

        container.add(addToCartButton);
        if (media instanceof Playable){
        	
        	JButton playButton = new JButton("Play");
        	playButton.addActionListener(new ActionListener() {
        		@Override
        		public void actionPerformed(ActionEvent e) {
        			JDialog dialog = new JDialog();
        			dialog.setTitle("Playing: " + media.getTitle());
        			dialog.setSize(400, 300);
        			dialog.setModal(true);
        			dialog.setLocationRelativeTo(null);
        			
        			JPanel dialogContent = new JPanel();
        			dialogContent.add(new JLabel("Media Player Placeholder"));
        			dialog.getContentPane().add(dialogContent);
        			dialog.setVisible(true);
        		}
        	});
            container.add(new JButton("Play"));
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
