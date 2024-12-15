package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Track;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField idTF;
	private JTextField titleTF;
	private JTextField categoryTF;
	private JTextField directorTF;
	private JTextField lengthTF;
	private JTextField artistTF;
	private JTextField tracksTF;
	private JTextField costTF;
	
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}
	
	@Override
	protected void initComponents() {
		setTitle("Add CD");
		setLayout(new GridLayout(9, 2));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		JLabel idLbl = new JLabel("Id: ");
		idTF = new JTextField();
		
		JLabel titleLbl = new JLabel("Title: ");
		titleTF = new JTextField();
		
		JLabel categoryLbl = new JLabel("Category: ");
		categoryTF = new JTextField();
		
		JLabel directorLbl = new JLabel("Director: ");
		directorTF = new JTextField();
		
		JLabel lengthLbl = new JLabel("Length: ");
		lengthTF = new JTextField();
		
		JLabel artistLbl = new JLabel("Artist: ");
        artistTF = new JTextField();
        
        JLabel tracksLbl = new JLabel("Tracks: ");
        tracksTF = new JTextField();
		
		JLabel costLbl = new JLabel("Cost: ");
		costTF = new JTextField();
		
		JButton addButton = new JButton("Add CD");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idTF.getText());
				String title = titleTF.getText();
				String category = categoryTF.getText();
				String director = directorTF.getText();
				int length = Integer.parseInt(lengthTF.getText());
				String artist = artistTF.getText();
				String tracksText = tracksTF.getText();
                String[] tracksArr = tracksText.split(",");
                List<Track> tracks = new ArrayList<>();
                 for (String track : tracksArr) {
                    String[] trackData = track.split(":");
                    String trackTitle = trackData[0].trim();
                    int trackLength = Integer.parseInt(trackData[1].trim());
                    tracks.add(new Track(trackTitle, trackLength));
                }
				float cost = Float.parseFloat(costTF.getText());
				
				CompactDisc cd = 
						new CompactDisc(id, title, category, director, length, artist, tracks, cost);
				store.addMedia(cd);
				dispose();
			}
		});
		add(idLbl);
        add(idTF);
        
        add(titleLbl);
        add(titleTF);
        
        add(categoryLbl);
        add(categoryTF);
        
        add(directorLbl);
        add(directorTF);
        
        add(lengthLbl);
        add(lengthTF);
        
        add(artistLbl);
        add(artistTF);
        
        add(tracksLbl);
        add(tracksTF);
        
        add(costLbl);
        add(costTF);
        
        add(new JLabel());
        add(addButton);
	} 
	@Override
	protected void addComponents() {
		pack();
	}
	@Override
	public void showScreen() {
		setVisible(true);
	}
}
