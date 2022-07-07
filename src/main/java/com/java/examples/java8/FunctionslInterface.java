/**
 * 
 */
package com.java.examples.java8;

/**
 * @author Arbind Negi 12-Feb-2021
 *
 */
public @FunctionalInterface interface FunctionslInterface {
    
    public String getMoney();
    
    public default String getAcctDetails() {
	
	return "hi";
    }

}
