/**
 * 
 */
package com.java.examples.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arbind Negi 17-Oct-2021
 *
 */
public class PrintAlfabet {

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println("Small letter Alphabet...........");
      List<String> alphaSmall = getAlphaInSmallLetter();
      alphaSmall.stream().forEach(e -> System.out.print(e + " "));
      
      System.out.println("\n \nCapital letter Alphabet...........");
      List<String> alphaCapital = getAlphaInCapitalLetter();
      alphaCapital.stream().forEach(e -> System.out.print(e + " "));
    }
    
    private static List<String> getAlphaInSmallLetter() {
	 List<String> alpha = new ArrayList<>();
	int n = 97; // 97 = a , 122 = z
	while (n <= 122) {
	    char c = (char) n;
	    alpha.add(String.valueOf(c));
	    n++;
	}
	
	return alpha;
    }

    private static List<String> getAlphaInCapitalLetter() {
	 List<String> alpha = new ArrayList<>();
	int n = 65; // 65 = A , 90 = Z
	while (n <= 90) {
	    char c = (char) n;
	    alpha.add(String.valueOf(c));
	    n++;
	}
	
	return alpha;
    }
}
