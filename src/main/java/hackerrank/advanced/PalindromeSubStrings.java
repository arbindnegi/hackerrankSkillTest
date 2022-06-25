/**
 * 
 */
package hackerrank.advanced;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Arbind Negi 16-Jun-2022
 *
 */
class PalindromeSubStrings {
    public static Set<String> findAllPalindromeSubstrings(String input) {
	Set<String> palindromes = new HashSet<>();
	for (int i = 0; i < input.length(); i++) {
	    for (int j = i + 1; j <= input.length(); j++) {
		if (isPalindrome(input.substring(i, j))) {
		    palindromes.add(input.substring(i, j));
		}
	    }
	}
	return palindromes;
    }

    private static boolean isPalindrome(String input) {
	if(input.length() > 1) {
	    StringBuilder plain = new StringBuilder(input);
	    StringBuilder reverse = plain.reverse();
	    return (reverse.toString()).equals(input);
	}
	return false;
    }
    
    public static void main(String[] args) {
	    String str = "abaab";
	    Set collectionOfSubStrings = findAllPalindromeSubstrings(str);
	    System.out.println("palindrome substrings: " + collectionOfSubStrings);
	    System.out.println("palindrome substrings counts: " + collectionOfSubStrings.size());
	    
	    System.out.println("Largest palindrome String:" + Collections.max(collectionOfSubStrings));
	  }
}
