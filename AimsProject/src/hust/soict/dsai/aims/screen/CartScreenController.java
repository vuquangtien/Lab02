package hust.soict.dsai.aims.screen;

import java.util.function.Predicate;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

import javafx.beans.binding.Bindings;
import javafx.beans.value.*;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CartScreenController {
	
	private Cart cart;
	private FilteredList<Media> filteredMediaList;
	
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
    private Button btnPlaceOrder;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Label lblTotalCost;
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
        		new ChangeListener<Media>() {
        			
        			@Override
        			public void changed(ObservableValue<? extends Media> observable, Media oldValue,
        					Media newValue) {
        				if(newValue != null) {
        					updateButtonBar(newValue);
        				}
        			}
        		});
        
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
        	@Override
        	public void changed(ObservableValue<? extends String> observable, String oldValue,
        			String newValue) {
        		showFilteredMedia(newValue);
        	}
        });
        
        filteredMediaList = new FilteredList<>(cart.getItemsOrdered(), null);
        tblMedia.setItems(filteredMediaList);
        lblTotalCost.textProperty().bind(Bindings.format("$%.2f", cart.totalCost()));
        
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
	
	void showFilteredMedia(String filter) {
		filteredMediaList.setPredicate(new Predicate<Media>(){
			@Override
			public boolean test(Media media) {
				if (filter == null || filter.isEmpty()) {
					return true;
				}
				if (radioBtnFilterId.isSelected()) {
					return String.valueOf(media.getId()).contains(filter);
				}else {
					return media.getTitle().toLowerCase().contains(filter.toLowerCase());
				}
			}
		});
	}
}
