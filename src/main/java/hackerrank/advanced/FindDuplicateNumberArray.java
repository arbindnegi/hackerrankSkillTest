/**
 * 
 */
package hackerrank.advanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Arbind Negi 02-Oct-2021
 *
 */
public class FindDuplicateNumberArray {
    
    public static void main(String[] args) {
	Integer [] numbers = {1,3,6,4,5,3,8,8};
	List<Integer> listOfNumbers = Stream.of(numbers).collect(Collectors.toList());
	Set<Integer> duplicateItems = findDiplicateNumbers(listOfNumbers);
/*	for (Integer nums : result) {
	    System.out.println(nums);
	}*/
	System.out.println("---------Duplicate element list--------------");
	duplicateItems.forEach(System.out::println);
	
	System.out.println("---------Unique element list--------------");
	Set<Integer> uniqueItems = removeDuplicateNumbers(listOfNumbers);
	uniqueItems.forEach(System.out::println);
    }
    
    private static Set<Integer> findDiplicateNumbers(List<Integer> listOfNumbers) {
	Set<Integer> duplicateItems = new HashSet<>();
	
	return listOfNumbers.stream()
	.filter(duplicate -> !duplicateItems.add(duplicate))
	.collect(Collectors.toSet());
    }
    
    private static Set<Integer> removeDuplicateNumbers(List<Integer> listOfNumbers) {
	Set<Integer> uniqueItems = new HashSet<>();
	
	return listOfNumbers.stream()
	.filter(duplicate -> uniqueItems.add(duplicate))
	.collect(Collectors.toSet());
    }

}
