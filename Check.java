/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Date;

/**
 *
 * @author Mary
 */
public class Check {
    
    public Check() {
        
    }
    
    public static void checkIsNull(String field, String name) {
        if (field == null) {
            throw new NullPointerException(String.format("%s cannot be null",name));
        }
    }
    
    public static void checkIsEmpty(String field, String name) {
        if (field.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty",name));
        }
    }
    
    public static void checkIsNull(Date field, String name) {
        if (field == null) {
            throw new NullPointerException(String.format("%s cannot be null",name));
        }
    }
    
}
