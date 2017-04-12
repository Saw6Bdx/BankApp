package jfxui;
	
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.TitledPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TitledPane root = (TitledPane)FXMLLoader.load(getClass().getResource("NewUserWindow.fxml"));
                        //root.setPadding(new Insets(0,50,50,0)); // Possibilité de fixer la taille de la fenêtre ? 
			Scene scene = new Scene(root);
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
