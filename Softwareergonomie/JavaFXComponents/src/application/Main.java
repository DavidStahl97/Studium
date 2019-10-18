package application;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
	        primaryStage.setTitle("Hello World!");
	        
	        StackPane root = new StackPane();
	        
	        VBox vBox = new VBox();
	        vBox.setPadding(new Insets(10, 50, 50, 50));
	        vBox.setSpacing(10);
	        
	        root.getChildren().add(vBox);
	        
	        ObservableList<Node> list = vBox.getChildren();
	        
	        // Label
	        Label label = new Label();
	        label.setText("Hallo Welt");
	        
	        // Button
	        Button btn = new Button();         
	        btn.setText("Hallo Welt");         	               
	        root.getChildren().add(btn);
	        
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	FileChooser fileChooser = new FileChooser();
	            	fileChooser.setTitle("Open Resource File");
	            	fileChooser.showOpenDialog(primaryStage);
	            }
	        });	      
	        
	        // Checkbox
	        CheckBox cb = new CheckBox();
	        cb.setText("CheckBox");
	        
	        
	        // RadioButton
	        RadioButton r1 = new RadioButton();
	        r1.setText("Option 1");
	        RadioButton r2 = new RadioButton();
	        r2.setText("Option 2");
	        RadioButton r3 = new RadioButton();
	        r3.setText("Option 3");
	        
	        ToggleGroup group = new ToggleGroup();
	        
	        r1.setToggleGroup(group);
	        r2.setToggleGroup(group);
	        r3.setToggleGroup(group);	        
	        
	        // MenuBar
	        MenuItem menuItem1 = new MenuItem("Option 1");
	        MenuItem menuItem2 = new MenuItem("Option 2");
	        MenuItem menuItem3 = new MenuItem("Option 3");

	        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);	    
	        
	        // ProgressBar
	        ProgressBar bar = new ProgressBar();
	        bar.setProgress(0.5);        
	        
	        // Slider
	        Slider slider = new Slider(0, 100, 20);	        
	        
	        // PasswordField
	        PasswordField passwordField = new PasswordField();	      
	        
	        
	        list.addAll(cb, label, btn, r1, r2, r3, menuButton, bar, slider, passwordField); 
	        
	        primaryStage.setScene(new Scene(root, 800, 600));         
	        primaryStage.show(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
