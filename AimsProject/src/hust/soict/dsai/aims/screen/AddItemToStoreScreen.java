package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
	
	protected Store store;
	protected abstract void initComponents();
	protected abstract void addComponents();
	
	public abstract void showScreen();
	
	public AddItemToStoreScreen(Store store) {
		this.store = store;
		initComponents();
		addComponents();
	}
}
