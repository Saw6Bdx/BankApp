package jfxui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
	try {
            this.emf = Persistence.createEntityManagerFactory("BankAppPU");
            this.mediator = new Mediator(this.emf);
  	
            Scene scene = new Scene(ControllerBase.loadFxml("LoginWindow.fxml", mediator));
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            }
            catch(Exception e) {
		e.printStackTrace();
            }
    }

    @Override
    public void stop() throws Exception {
        this.emf.close();
        super.stop();
    }  
	
    public static void main(String[] args) {
	launch(args);
    }
    
    private Mediator mediator = null;
    private EntityManagerFactory emf = null;
}