package jfxui;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;

public class MainWindowController {
	@FXML
	private Pane content;
	
	
	/*@FXML
	private void handleMenuFileOpen(ActionEvent event){
		FileChooser chooser = new FileChooser();
		File choix = chooser.showOpenDialog(null);
		String err = "";
		
		if(choix != null){
			try{
				FileReader fr = new FileReader(choix);
				try{
					TaskCollection coll = TaskCollection.fromCsv(fr);
					fr.close();
					//Charger le fichier
				
				//choix.getAbsolutePath();
				
				//Charger le fxml et son contr�leur
					try{
						FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskList.fxml"));
						Node root = (Node)loader.load();
						
						//Le mettre dans 'content'
						content.getChildren().setAll(root);
					}
					catch(IOException e){
						err = "Erreur lors de la pr�paration de l'affichage de la liste : " + e.getMessage();
					}
				}
				catch(IOException e){
					err = "Erreur lors de la lecture du csv : " + e.getMessage(); 
				}
				catch(InvalidCsvFormatException e){
					err = "Erreur de format csv : " + e.getMessage();
				}
			}
			catch(IOException e){
				err = "Erreur d'ouverture du csv : " + e.getMessage();
			}
			if(err.isEmpty()){
				new Alert(AlertType.ERROR, err).showAndWait();
			}
		}
	}*/
	
	@FXML
	private void handleMenuFileQuit(ActionEvent event){
		Alert alert = new Alert(AlertType.CONFIRMATION, "Vous �tes s�r de vouloir quitter ?", ButtonType.OK, ButtonType.CANCEL);
		Optional<ButtonType> result = alert.showAndWait();
		
		if(result.isPresent() && result.get() == ButtonType.OK){
		Platform.exit();
		}
	}
}