package com.java.examples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
	 public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
	    
	    List<Integer> listOfIntegers = listOfStrings.stream()
                                    .map(Integer::valueOf)
                                    .collect(Collectors.toList());
     
         System.out.println(listOfIntegers);
         
         List<Integer> even = listOfStrings.stream()
                 .map(s -> Integer.valueOf(s))
                 .filter(number -> number % 2 == 0)
                 .collect(Collectors.toList());
        System.out.println("processed list, only even numbers: " + even);
    }

}
