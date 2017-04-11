
package projetJava;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Charlotte
 */
public class AccountManagerTest {
    /*  name VARCHAR(250) NOT NULL,
	firstName VARCHAR(250) NOT NULL,
	phone VARCHAR(250),
	email VARCHAR(250),
	assignementDate DATE NOT NULL,*/
    
    @Test(expected = NullPointerException.class)
    public void testTask_NameIsNull() {
        new AccountManager(null, "bar", "0000000000", "foo.bar@foobar.fr", new Date(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTask_NameIsEmpty() {
        new AccountManager("", "bar", "0000000000", "foo.bar@foobar.fr", new Date(0));
    }
    
    @Test(expected = NullPointerException.class)
    public void testTask_FirstNameIsNull() {
        new AccountManager("foo", null, "0000000000", "foo.bar@foobar.fr", new Date(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTask_FirstNameIsEmpty() {
        new AccountManager("foo", "", "0000000000", "foo.bar@foobar.fr", new Date(0));
    }
    
    @Test(expected = NullPointerException.class)
    public void testTask_PhoneIsNull() {
        new AccountManager("foo", "bar", null, "foo.bar@foobar.fr", new Date(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTask_PhoneIsInvalid() {
        new AccountManager("foo", "bar", "00000H0000", "foo.bar@foobar.fr", new Date(0));
    }
    
    @Test(expected = NullPointerException.class)
    public void testTask_EmailIsNull() {
        new AccountManager("foo", "bar", "0000000000", null, new Date(0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTask_EmailIsInvalid() {
        new AccountManager("foo", "bar", "0000000000", "foo.bar foobar.fr", new Date(0));
    }
    
    @Test(expected = NullPointerException.class)
    public void testTask_DateIsNull() {
        new AccountManager("foo", "bar", "0000000000", "foo.bar@foobar.fr", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testTask_assignementDateInTheFuture() {
        new AccountManager("foo", "bar", "0000000000", "foo.bar@foobar.fr", new GregorianCalendar(2017, Calendar.JULY, 10, 12, 31, 15).getTime());
    }

    @Test
    public void testGetManager_name() {
        this.tested = new AccountManager("foo", "bar", "0000000000", "foo.bar@foobar.fr", new Date(0));
        assertEquals("foo", this.tested.getManager_name());
    }

    @Test
    public void testGetManager_firstName() {
        this.tested = new AccountManager("foo", "bar", "0000000000", "foo.bar@foobar.fr", new Date(0));
        assertEquals("bar", this.tested.getManager_firstName());
    }

    @Test
    public void testGetManager_phone() {
        this.tested = new AccountManager("foo", "bar", "0000000000", "foo.bar@foobar.fr", new Date(0));
        assertEquals("0000000000", this.tested.getManager_phone());
    }

    @Test
    public void testGetManager_email() {
        this.tested = new AccountManager("foo", "bar", "0000000000", "foo.bar@foobar.fr", new Date(0));
        assertEquals("foo.bar@foobar.fr", this.tested.getManager_email());
    }

    @Test
    public void testGetManager_assignementDate() {
        this.tested = new AccountManager("foo", "bar", "0000000000", "foo.bar@foobar.fr", new GregorianCalendar(2017, Calendar.APRIL, 10, 12, 31, 15).getTime());
        assertEquals(new GregorianCalendar(2017, Calendar.APRIL, 10, 12, 31, 15).getTime(), this.tested.getManager_assignementDate());
    }
    
    private AccountManager tested;
}
