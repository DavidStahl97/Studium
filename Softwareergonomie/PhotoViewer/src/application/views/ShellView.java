package application.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShellView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		 primaryStage.setTitle("Photo Viewer");
		 
		 BorderPane dockPane = new BorderPane();
		 
		 PictureListView pictureListView = new PictureListView();
		 dockPane.setLeft(value);
		 
	     primaryStage.setScene(new Scene(dockPane, 800, 600));         
	     primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
