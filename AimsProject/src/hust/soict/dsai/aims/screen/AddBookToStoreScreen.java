package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import java.util.List;
import java.util.Arrays;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private JTextField idTF;
	private JTextField titleTF;
	private JTextField categoryTF;
	private JTextField authorsTF;
	private JTextField costTF;
	
	public AddBookToStoreScreen(Store store) {
		super(store);
	}
	
	@Override
	protected void initComponents() {
		setTitle("Add Book");
		setLayout(new GridLayout(6, 2));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		JLabel idLbl = new JLabel("Id: ");
		idTF = new JTextField();
		
		JLabel titleLbl = new JLabel("Title: ");
		titleTF = new JTextField();
		
		JLabel categoryLbl = new JLabel("Category: ");
		categoryTF = new JTextField();
        
        JLabel authorsLbl = new JLabel("Authors: ");
        authorsTF = new JTextField();
		
		JLabel costLbl = new JLabel("Cost: ");
		costTF = new JTextField();
		
		JButton addButton = new JButton("Add CD");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idTF.getText());
				String title = titleTF.getText();
				String category = categoryTF.getText();
				String authorsText = authorsTF.getText();
                List<String> authors = Arrays.asList(authorsText.split(","));
				float cost = Float.parseFloat(costTF.getText());
				
				Book book = new Book(id, title, category, authors, cost);
				store.addMedia(book);
				dispose();
			}
		});
		add(idLbl);
        add(idTF);
        
        add(titleLbl);
        add(titleTF);
        
        add(categoryLbl);
        add(categoryTF);
        
        add(authorsLbl);
        add(authorsTF);
        
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
