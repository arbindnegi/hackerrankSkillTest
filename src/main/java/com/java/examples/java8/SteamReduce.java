package com.java.examples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class SteamReduce {

	public static void main(String[] args) {
		// Creating list of integers 
        List<Integer> array = Arrays.asList(-2, 1, 4, 6, 8); 
  
        // Finding sum of all elements 
        int sum = array.stream().reduce(0, 
                (element1, element2) -> element1 + element2); 
  
        int SUM_METHOD_REF = array.stream().reduce(0, Integer::sum);
        int result = array.stream().reduce((first, next) -> first+next)
	     .orElse(-1);
	     
        // Displaying sum of all elements 
        System.out.println("The sum of all elements is " + sum); 
        System.out.println("The sum of all elements with method ref is " + SUM_METHOD_REF); 
        System.out.println("The sum of all elements is " + result); 
        
     // To get the product of all elements 
        // in given range excluding the 
        // rightmost element 
        int product = IntStream.range(1, 3) 
                     .reduce((num1, num2) -> num1 * num2) 
                     .orElse(-1); 
  
        // Displaying the product 
        System.out.println("The product is : " + product);
        
     int multiplayresult = array.stream().reduce((first, next) -> first*next)
	     .orElse(-1); ;
     System.out.println("The product is : " + multiplayresult);
        
     // String array 
        String[] stringArray = { "Year", "Month", "Week", "Day" }; 
  
        // The result of the reduce() method is 
        // an Optional because the list on which 
        // reduce() is called may be empty. 
        Optional<String> String_combine = Arrays.stream(stringArray) 
                                           .reduce((str1, str2) 
                                           -> str1 + "-" + str2);
        System.out.println(String_combine.get()); 

	}

}
