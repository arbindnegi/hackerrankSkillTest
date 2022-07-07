/**
 * 
 */
package com.java.examples.java8;

/**
 * @author Arbind Negi 25-Feb-2021
 *
 */
public interface DefaultInterface {
    default void defaultMethod(){  
        System.out.println("Newly added default method");  
    }  
 
    static void staticNewMethod(){
    	System.out.println("Newly added static method");
    }
    
    void existingMethod(String str);  

}
