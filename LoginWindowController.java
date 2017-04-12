package jfxui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class LoginWindowController {   
    @FXML private TextField labelLogin;
    @FXML private PasswordField labelPassword;
	
    @FXML
    private void handleLoginWindowLogin(ActionEvent event) throws IOException{
        if(labelLogin.getText().equals("Login") && labelPassword.getText().equals("26929999")){
            TitledPane loader = (TitledPane)FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            //Hide current window
            ((Node)(event.getSource())).getScene().getWindow().hide();
            System.out.print("Pwd OK");
            System.out.print("Login OK");
        }
        else{
            new Alert(AlertType.ERROR, "Login or pwd are invalid").showAndWait();
        }
    }
        
        /*Alert alert = new Alert(AlertType.CONFIRMATION, "Vous êtes sûr de vouloir quitter ?", ButtonType.OK, ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            FXMLLoader loader = new FXMLLoader(getClass().getResource(".fxml"));
        }
    }*/
        
    @FXML
    private void handleLoginWindowCreate(ActionEvent event){
        /*Alert alert = new Alert(AlertType.CONFIRMATION, "Vous êtes sûr de vouloir quitter ?", ButtonType.OK, ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
        
        }*/
    }
}