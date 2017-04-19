package jfxui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUserWindowController extends ControllerBase{
    
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
    
    @Override
    public void initialize(Mediator mediator){
    }
    
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
        
        if ( checkLetters(name,"name") && checkLetters(firstName, "first name") && 
                checkDate(birthday) && checkPhoneNumber(phone) && 
                checkEmail(email) && checkPwd(pwd, pwdConfirm) ) {
          
            birthday = convFormatDate(birthday); // convert from dd/MM/yyyy to yyyy-MM-dd
            
            // Add informations to the BDD
            /* NOT IMPLEMENTED */
            
            // Going to the application main page
            this.emf = Persistence.createEntityManagerFactory("BankAppPU");
            this.mediator = new Mediator(this.emf);
        
            Scene scene = new Scene(ControllerBase.loadFxml("AppWindow.fxml", mediator));
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        
            //Close current window
            Stage current = (Stage)btnCreate.getScene().getWindow();
            current.close();
           
        }
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
        System.out.println(result);
        return result;
    }
    
    /**
     * Method which checks the name format (if it contains only letters)
     * @param field, the field to be checked 
     * @param nameField, the name of the field to be checked
     * @return true if the field is in the good format, false otherwise
     */
    private boolean checkLetters(String field, String nameField) {
        if ( field.matches("[a-zA-Z]+") ) {
            return true;
        }
        new Alert(
                AlertType.WARNING,
                String.format("Invalid %s format\n Only letters allowed",nameField)
        ).showAndWait();
        return false;
    }
    
    /**
     * Method which checks the phone number format (if it contains only numbers or +)
     * @param phone, the field to be checked 
     * @return true if the field is in the good format, false otherwise
     */
    private boolean checkPhoneNumber(String phone) {
        if ( phone.matches("[0-9]+") && phone.length() >= 10 ) { // vérifier qu'il y ait un + ?
            return true;
        }
        new Alert(AlertType.WARNING,"Invalid phone number format\n Characters allowed : numbers and + ").showAndWait();
        return false;
    }
    
    /**
     * Method which checks the e-mail number format (if it contains one @)
     * @param email, the field to be checked
     * @return true if the field is in the good format, false otherwise
     */
    private boolean checkEmail(String email) {
        if ( email.matches(".*@.*") ) {
            return true;
        }
        new Alert(AlertType.WARNING,"Invalid e-mail format\n Must contains an @").showAndWait();
        return false;
    }
    
    /**
     * Method which checks the date
     * @param field, the field to be checked 
     * @return true if the field is not empty, false otherwise
     */
    private boolean checkDate(String date) {
        if (!date.isEmpty()) {
            return true;
        }
        new Alert(AlertType.WARNING, "date field cannot be empty").showAndWait();
        return false;
    }
    
    /**
     * Method which checks if the password and its confirmation match
     * @param pwd, pwdConfirmation the field to be checked
     * @return true if fields match, false otherwise
     */
    private boolean checkPwd(String pwd, String pwdConfirmation) {
        if ( pwd.equals(pwdConfirmation) ) {
            return true;
        }
        new Alert(AlertType.WARNING,"Password and its confirmation does not match").showAndWait();
        return false;
    }
    
    @FXML
    /**
     * When the user clicks on the Cancel button, the application goes back to the Login Window 
     * and closes the New User Window.
     */
    private void handleBtnCancel(ActionEvent event) throws IOException {
        
        // Going back to the Login window
        this.emf = Persistence.createEntityManagerFactory("BankAppPU");
        this.mediator = new Mediator(this.emf);
        
        Scene scene = new Scene(ControllerBase.loadFxml("LoginWindow.fxml", mediator));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        //Close current window
        Stage current = (Stage)btnCreate.getScene().getWindow();
        current.close();
        
    }
    private Mediator mediator = null;
    private EntityManagerFactory emf = null;
    
}