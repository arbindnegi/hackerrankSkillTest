/**
 * 
 */
package hackerrank.advanced;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arbind Negi 02-Oct-2021
 *
 */
public class FindDuplicateCharactersAndCoutFromString {
    public static void main(String[] args) {
	String str = "Hello this is java prigrammer";
	getDuplicateCharAndCount(str);
    }
    
    private static void getDuplicateCharAndCount(String str) {
	Map<Character, Integer> charMap = new HashMap<>();
	char[] ch = str.toCharArray();
	for(Character chartrs : ch) {
	    if (charMap.containsKey(chartrs) && !Character.isWhitespace(chartrs) ) {
		charMap.put(chartrs, charMap.get(chartrs) + 1);
	    } else {
		charMap.put(chartrs, 1);
	    }
	}
	
	System.out.printf("List of duplicate characters in String '%s' %n", str);

	charMap.forEach((key, value) -> {
	    if (value > 1) {
		System.out.printf("%s : %d %n", key, value);
	    }
	});
    }
    
}
