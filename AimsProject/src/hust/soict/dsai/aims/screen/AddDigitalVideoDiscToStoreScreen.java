package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField idTF;
	private JTextField titleTF;
	private JTextField categoryTF;
	private JTextField directorTF;
	private JTextField lengthTF;
	private JTextField costTF;
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
	}
	
	@Override
	protected void initComponents() {
		setTitle("Add DVD");
		setLayout(new GridLayout(7, 2));
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
		
		JLabel costLbl = new JLabel("Cost: ");
		costTF = new JTextField();
		
		JButton addButton = new JButton("Add DVD");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idTF.getText());
				String title = titleTF.getText();
				String category = categoryTF.getText();
				String director = directorTF.getText();
				int length = Integer.parseInt(lengthTF.getText());
				float cost = Float.parseFloat(costTF.getText());
				
				DigitalVideoDisc dvd = 
						new DigitalVideoDisc(id, title, category, director, length, cost);
				store.addMedia(dvd);
				dispose();
			}
		});
		add(idLbl);
        add(idTF);
        
        add(titleLbl);
        add(titleTF);
        
        add(categoryLbl);
        add(categoryTF);
        
        add(costLbl);
        add(costTF);
        
        add(lengthLbl);
        add(lengthTF);
        
        add(directorLbl);
        add(directorTF);
        
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
