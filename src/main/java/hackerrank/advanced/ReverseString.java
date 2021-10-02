/**
 * 
 */
package hackerrank.advanced;

/**
 * @author Arbind Negi 02-Oct-2021
 *
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello my name is Arbind";
        printReverseString(str);
    }
    
    private static void printReverseString(String str) {
	if (str==null || str.length() <= 1) {
	    System.out.println(str);
	} else {
        	System.out.print(str.charAt(str.length() - 1));
        	printReverseString(str.substring(0, str.length() - 1));
	}
    }
}
