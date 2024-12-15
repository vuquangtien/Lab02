package hust.soict.dsai.javafx;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class PaintController {
	private int mode = 0;
	
    @FXML
    private VBox controlPane;

    @FXML
    private ToggleGroup Toggle;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle;
    	switch(mode) {
    	case 0:
    		break;
    	case 1:
    		newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
    		drawingAreaPane.getChildren().add(newCircle);
    		break;
    	case 2:
    		newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
    		drawingAreaPane.getChildren().add(newCircle);
    		break;
    	}
    	
    }
    
    @FXML
    void setEraser(ActionEvent event) {
    	this.mode = 2;
    }

    @FXML
    void setPen(ActionEvent event) {
    	this.mode = 1;
    }

}
