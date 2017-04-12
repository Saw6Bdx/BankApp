package jfxui;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

import projetJava.Holder;
import projetJava.Login;
import utils.Valid;

/**
 *  
 * @author Mary
 */
public class NewUserWindowController {
    
    @FXML private TextField txtName;
    @FXML private TextField txtFirstName;
    @FXML private TextField txtPhone;
    @FXML private TextField txtEmail;
    @FXML private DatePicker txtBirthday;
    @FXML private TextField txtLogin;
    @FXML private PasswordField txtPwd;
    @FXML private PasswordField txtConfirmPwd;
    @FXML private Button btnCreate;
    @FXML private Button btnCancel;
    
    @FXML
    private void handleBtnCreate(ActionEvent event) throws IOException {
    
        String name = txtName.getText();
        String firstName = txtFirstName.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String birthday = txtBirthday.getEditor().getText();
        
        String login = txtLogin.getText();
        String pwd = txtPwd.getText();
        String pwdConfirm = txtConfirmPwd.getText();
        
        // Convert birthday date from dd/MM/yyyy to yyyy-MM-dd
        if ( Valid.isValidDate(birthday) ) {
            birthday = convFormatDate(birthday);
            SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date d = dateParser.parse(birthday);
            } catch (ParseException ex) {
            }
        }
        else {
            alertMessage("date","Date field cannot be empty");
        }
        
        // Check the fields
        if ( Valid.isValidLetters(name, "name") ) {
            if ( Valid.isValidLetters(firstName, "first name") ) {
                if ( Valid.isValidPhoneNumber(phone) ) {
                    if ( Valid.isValidEmail(email) ) {
                        
                        // Creating Holder object
                        Holder h = new Holder(name,firstName,phone,email,new Date(0));
                        
                        if (Valid.isValidPwd(pwd, pwdConfirm)) {
                            
                            // Creating Login object
                            Login l = new Login(login,pwd);
                            
                            // Going to the application main page
                            TitledPane loader = (TitledPane)FXMLLoader.load(getClass().getResource("AppWindow.fxml"));
                            Scene scene = new Scene(loader);
                            Stage stage = new Stage();
                            stage.setScene(scene);
                            stage.show();

                            //Close current window
                            Stage current = (Stage)btnCreate.getScene().getWindow();
                            current.close();
                        
                        }
                        else {
                            alertMessage("password","password and its confirmation do not match");
                        }
                    }
                    else {
                        alertMessage("e-mail","Must contains an @");
                    }
                }
                else {
                    alertMessage("phone","Characters allowed : numbers and +");
                    System.out.println("Wrong phone");
                }
            }
            else {
                alertMessage("first name","Only letters and hyphen allowed");
            }
        } 
        else {
            alertMessage("name","Only letters and apostrophe allowed");
        }
        
    }
    
    /**
     * Method 
     * @param date in dd/MM/yyyy format
     * @return date in yyyy-mm-dd format
     */
    private void alertMessage(String field, String message) {
        new Alert(
                Alert.AlertType.WARNING,
                String.format("Invalid %s format\n %s",field,message)
            ).showAndWait();
    }
    
    /**
     * Method which changes the date format
     * @param date in dd/MM/yyyy format
     * @return date in yyyy-mm-dd format
     */
    private String convFormatDate(String date) {
        String[] parts = date.split("/");
        String result = "";
        for (int i = parts.length - 1 ; i >= 0 ; i-- ) {
            result = result.concat(parts[i]);
            if (i != 0 ) {
                result = result.concat("-");
            }
        }
        return result;
    }
    
    @FXML
    /**
     * When the user clicks on the Cancel button, the application goes back to the Login Window 
     * and closes the New User Window.
     */
    private void handleBtnCancel(ActionEvent event) throws IOException {
        
        // Going back to the Login window
        TitledPane loader = (TitledPane)FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        //Close current window
        Stage current = (Stage)btnCreate.getScene().getWindow();
        current.close();
        
    }
    
}