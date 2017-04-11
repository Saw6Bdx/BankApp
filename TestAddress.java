/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetJava;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guest
 */
public class TestAddress {
    
    public TestAddress() {
    }
    
    @Before
    public void setup() { // appelée avant chaque test
        this.tested = new Address("foo","bar","foo2","bar2");
    }
   
    
    // Tests sur le constructeur 
    
    @Test(expected = NullPointerException.class)
    public void testAddress_Line1IsNull() {
        new Address(null,"bar","foo2","bar2");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddress_Line1IsEmpty() {
        new Address("","bar","foo2","bar2");
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddress_Line2IsNull() {
        new Address("foo",null,"foo2","bar2");
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddress_PostCodeIsNull() {
        new Address("foo","bar",null,"bar2");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddress_PostCodeIsEmpty() {
        new Address("foo","bar","","bar2");
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddress_CityIsNull() {
        new Address("foo","bar","foo2",null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddress_CityIsEmpty() {
        new Address("foo","bar","foo2","");
    }
    
    
    // Tests sur les getters
    
    //String line1, String line2, String postCode, String city
    
    @Test
    public void testGetLine1() {
        assertEquals("foo",this.tested.getLine1());
    }
    
    @Test
    public void testGetLine2() {
        assertEquals("bar",this.tested.getLine2());
    }
    
    @Test
    public void testGetPostCode() {
        assertEquals("foo2",this.tested.getPostCode());
    }
    
    @Test
    public void testGetCity() {
        assertEquals("bar2",this.tested.getCity());
    }
    
    private Address tested;
    
}
