package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox vbox = new VBox();
			
			ProgressBar bar = new ProgressBar();
			
			Button button = new Button();
			button.setText("Start");
			
			button.setOnMouseClicked(e -> {
				Task<String> task = new Task<String>() {

					@Override
					protected String call() throws Exception {
						for(int i = 0; i < 100; i++)
						{
							double value = (double)i / 100;
							Platform.runLater(() -> {
								bar.setProgress(value);
							});
							
							Thread.sleep(100);
						}
						
						return "succed";
					}
					
				};
				
				new Thread(task).start();
				
			});
		
			vbox.getChildren().addAll(button, bar);
			
			Scene scene = new Scene(vbox,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
