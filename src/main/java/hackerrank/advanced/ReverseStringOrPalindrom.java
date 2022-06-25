/**
 * 
 */
package hackerrank.advanced;

/**
 * @author Arbind Negi 02-Oct-2021
 *
 */
public class ReverseStringOrPalindrom {
    public static void main(String[] args) {
        String str = "aabbbbaa";
        String result = printReverseString(str);
        System.out.println("Reverse string: "+result);
        
        //check is the reverse of string is same or is Palindrom
        if (str.equals(result)) {
            System.out.println("'"+str +"'" + " is Palindrom");
        } else {
            System.out.println("'"+str +"'" + " is not Palindrom");
        }
    }
    
    private static String printReverseString(String str) {
	if (str==null || str.isEmpty()) {
	    System.out.println(str);
	    return str;
	} else {
	    char c = str.charAt(str.length() - 1); 
	   // System.out.print(c);
        return   c + printReverseString(str.substring(0, str.length() - 1));
	}
    }
}
