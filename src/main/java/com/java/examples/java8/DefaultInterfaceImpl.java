/**
 * 
 */
package com.java.examples.java8;

/**
 * @author Arbind Negi 25-Feb-2021
 *
 */
public class DefaultInterfaceImpl implements DefaultInterface{

    /* (non-Javadoc)
     * @see com.demo.tutorial.javaTutorial.java8.DefaultInterface#existingMethod(java.lang.String)
     */
    @Override
    public void existingMethod(String str) {
	System.out.println("Implemantion class overridoing the: " + str);
	
    }

    @Override
    public void defaultMethod(){  
        System.out.println("default method calling from impl class");  
    }  

    public static void main(String[] args) {
	DefaultInterfaceImpl obj = new DefaultInterfaceImpl();
	obj.existingMethod("exiting method");
	obj.defaultMethod();
	
	DefaultInterface.staticNewMethod();
    }

}
