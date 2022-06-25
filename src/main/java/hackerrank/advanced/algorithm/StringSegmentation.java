/**
 * 
 */
package hackerrank.advanced.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Arbind Negi 16-Jun-2022
 *
 */
public class StringSegmentation {

    public static void main(String[] args) {
	Set<String> dictionary = new HashSet<>();
	dictionary.add("Hello");
	dictionary.add("What");
	dictionary.add("Arbind");
	dictionary.add("Bye");

	String str = "HelloArbindWhat";
	if (isStringSegmentation(str, dictionary)) {
	    System.out.println("String is Segmented");
	} else {
	    System.out.println("String is NOT Segmented");
	}
    }

    private static boolean isStringSegmentation(String str, Set<String> stringDictionary) {

	for (int i = 1; i <= str.length(); ++i) {
	    String firstSubString = str.substring(0, i);
	    if (stringDictionary.contains(firstSubString)) {
		String remainingSubString = str.substring(i);

		if (remainingSubString.length() == 0 || stringDictionary.contains(remainingSubString)
			|| isStringSegmentation(remainingSubString, stringDictionary)) {
		    return true;
		}
	    }
	}
	return false;
    }
}
