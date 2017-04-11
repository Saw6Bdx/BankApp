package projetJava;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAccount {
    
    @Before
    public void setUp() {
    }
    
    @Test(expected = NullPointerException.class)
    public void testAccount_NumberIsNull(){
        new Account(null, new Date(0), "bar", "foo2", 0.0, 0.0, "bar2", 0.0); 
    }
    
    @Test(expected = NullPointerException.class)
    public void testAccount_CreationDateIsNull(){
        new Account("foo", null, "bar", "foo2", 0.0, 0.0, "bar2", 0.0); 
    }
    
    @Test(expected = NullPointerException.class)
    public void testAccount_TypeIsNull(){
        new Account("foo", new Date(0), null, "foo2", 0.0, 0.0, "bar2", 0.0); 
    }
    
    @Test(expected = NullPointerException.class)
    public void testAccount_CountryCodeIsNull(){
        new Account("foo", new Date(0), "bar", null, 0.0, 0.0, "bar2", 0.0); 
    }
    
    @Test(expected = NullPointerException.class)
    public void testAccount_DescriptionIsNull(){
        new Account("foo", new Date(0), "bar", "foo2", 0.0, 0.0, null, 0.0); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAccount_NumberIsEmpty(){
        new Account("", new Date(0), "bar", "foo2", 0.0, 0.0, "bar2", 0.0); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAccount_TypeIsEmpty(){
        new Account("foo", new Date(0), "", "foo2", 0.0, 0.0, "bar2", 0.0); 
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAccount_CountryCodeIsEmpty(){
        new Account("foo", new Date(0), "bar", "", 0.0, 0.0, "bar2", 0.0); 
    }
    
    @Test
    public void testGetNumber(){
        this.tested = new Account("foo", new Date(0), "bar", "foo2", 0.0, 0.0, "bar2", 0.0);
        assertEquals("foo", this.tested.getNumber());
    }
    
    @Test
    public void testGetType(){
        this.tested = new Account("foo", new Date(0), "bar", "foo2", 0.0, 0.0, "bar2", 0.0);
        assertEquals("bar", this.tested.getType());
    }
    
    @Test
    public void testGetCountryCode(){
        this.tested = new Account("foo", new Date(0), "bar", "foo2", 0.0, 0.0, "bar2", 0.0);
        assertEquals("foo2", this.tested.getCountryCode());
    }
    
    @Test
    public void testGetFirstBalance(){
        this.tested = new Account("foo", new Date(0), "bar", "foo2", 150.00, 0.0, "bar2", 0.75);
        assertEquals(150.00, this.tested.getFirstBalance(), 0.00);
    }
    
    @Test
    public void testGetOverdraft(){
        this.tested = new Account("foo", new Date(0), "bar", "foo2", 0.0, 200.00, "bar2", 0.0);
        assertEquals(200.00, this.tested.getOverdraft(), 0.00);
    }
    
    @Test
    public void testGetDescription(){
        this.tested = new Account("foo", new Date(0), "bar", "foo2", 0.0, 0.0, "bar2", 0.0);
        assertEquals("bar2", this.tested.getDescription());
    }
    
    @Test
    public void testGetInterestRate(){
        this.tested = new Account("foo", new Date(0), "bar", "foo2", 0.0, 0.0, "bar2", 0.75);
        assertEquals(0.75, this.tested.getInterestRate(), 0.00);
    }
    
    @Test(expected = IllegalArgumentException.class)
	public void testTask_CreateDateIntheFuture() {
            Calendar cal = new GregorianCalendar(2017, Calendar.APRIL, 13, 12, 31, 15);
            this.tested = new Account("foo", cal.getTime(), "bar", "foo2", 0.0, 0.0, "bar2", 0.00);
	}
    
    //String number, Date creationDate, String type, String countryCode, Double firstBalance, Double overdraft, String description, Double interestRate
    
    private Account tested;
}
