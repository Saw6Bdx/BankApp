
package jfxui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Charlotte
 */

public class AppWindowController {

    /*@FXML // à faire pour ajouter le tableau de compte dans la partie dédiée
    private Pane content;*/
    
    @FXML
    private void handleMenuFileChangeUser(ActionEvent event) throws IOException {
        TitledPane loader = (TitledPane)FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //Hide current window, ne fonctionne pas, à voir plus tard
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void handleMenuFileNewUser(ActionEvent event) throws IOException {
        TitledPane loader = (TitledPane)FXMLLoader.load(getClass().getResource("NewUserWindow.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //Hide current window, ne fonctionne pas, à voir plus tard
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    /* Implémentation en cours d'un nouveau bouton "compte" lors de la création d'un compte par l'utilisateur
    @FXML
    private void handleMenuEditNewAccount(ActionEvent event) throws Exception {
        Button btn = new Button("Compte Courant&#10;+1385,00€");
    }*/
}
