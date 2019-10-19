package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	private int layoutIndex = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox box = new VBox();
			
			List<Button> buttons = createButtonList();
			List<Node> layouts = createLayoutNodes(buttons);
			
			Button layoutButton = new Button();
			layoutButton.setText("Change Layout");
			
			layoutButton.setOnAction(e -> {
            	box.getChildren().clear();
            	
            	layoutIndex++;
            	int i = layoutIndex % layouts.size(); 
            	box.getChildren().addAll(layouts.get(i), layoutButton);
			});
			
			box.getChildren().addAll(layouts.get(layoutIndex), layoutButton);
			
			Scene scene = new Scene(box,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static List<Node> createLayoutNodes(List<Button> buttons)
	{
		List<Node> layouts = new ArrayList<Node>();
		layouts.add(createVBoxLayout(buttons));
		layouts.add(createHBoxLayout(buttons));
		
		return layouts;
	}
	
	private static Node createVBoxLayout(List<Button> buttons)
	{
		VBox box = new VBox();
		box.getChildren().addAll(buttons);
		return box;
	}
	
	private static Node createHBoxLayout(List<Button> buttons)
	{
		HBox box = new HBox();
		box.getChildren().addAll(buttons);
		return box;
	}
	
	private static Node flowPanalNode(List<Button> buttons)
	{
		FlowPane box = new FlowPane();
		box.getChildren().addAll(buttons);
		return box;
	}
	
	private static List<Button> createButtonList()
	{
		List<Button> buttons = new ArrayList<Button>();
		for(int i = 0; i < 10; i++)
		{
			Button b = new Button();
			b.setText(String.valueOf(i));
			buttons.add(b);
		}
		return buttons;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
