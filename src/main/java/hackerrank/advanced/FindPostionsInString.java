/**
 * 
 */
package hackerrank.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arbind Negi 26-Aug-2021
 *
 */
public class FindPostionsInString {
    public static void main (String [] args) {
	
	String str = "Hello My name is Arbind Arbind Negi and i am working in Barclays";
	char nextElement;
	char findChar = 'a';
	List<Integer> postionList = new ArrayList<>();
	/**
	 * Find the Position of characters  
	 */
	for (int i = 0; i <= str.length() -1; i++) {
	    nextElement = str.charAt(i);
	    if (nextElement == findChar) {
		postionList.add(i);
	    }
	}
	System.out.println("'"+findChar+"'" + " Occurence at " + postionList + " Postions");
	
	/**
	 * Find the Position of match in the String  
	 */
	 postionList.clear();
	    for (int i = 0; (i = str.indexOf("Arbind", i + 1)) != -1; i++) {
		    postionList.add(i);
		}
	System.out.println("Arbind" + " Occurence " + postionList.size() + " time in the sentance at the postion of " + postionList);
    }
    
}
