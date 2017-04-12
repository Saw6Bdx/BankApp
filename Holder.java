package projetJava;

import java.util.Calendar;
import java.util.Date;
import utils.Check;

/**
 *  
 * @author Mary
 */
public class Holder {

    public Holder(String name, String firstName, String phone, String email, Date date) {
        
        Check.checkIsEmpty(name,"name");
        Check.checkIsEmpty(firstName,"firstName");
        Check.checkIsNull(date,"date");
        if (date.getTime() > today().getTime()) {
           throw new IllegalArgumentException("birthday in the future");
        }
        Check.checkIsEmpty(phone,"phone");
        Check.checkIsEmpty(email,"email");
        
        this.name = name;
        this.firstName = firstName;
        this.date = date;
        this.phone = phone;
        this.email = email;
        
    }
    
    // Getters
    public String getName() {
        return this.name;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setAddress(String line1, String line2, String postCode, String city) {
        this.line1 = line1;
        this.line2 = line2;
        this.postCode = postCode;
        this.city = city;
    }
    
    private Date today() {
        return Calendar.getInstance().getTime();
    }
    
    private void setName(String name) {
        this.name = name;
    }
    
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    private void setPhone(String phone) {
        this.phone = phone;
    }
    
    private void setEmail(String email) {
        this.email = email;
    }
   
    private void setDarte(Date date){
        this.date = date;
    }
    
    private String name, firstName, phone, email; 
    private Date date;
    private String line1, line2, postCode, city;
    
    
}
