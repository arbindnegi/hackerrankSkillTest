/**
 * 
 */
package hackerrank.advanced.algorithm;

import java.util.Stack;

/**
 * @author Arbind Negi 19-Jun-2022
 *
 */
public class StringDecoded {

    /**
     * @param args
     */
    public static void main(String[] args) {
/*	String str1 = "3[b2[ca]]";
        System.out.println(getDecodedString(str1));

	String str2 = "1[b]";
        System.out.println(getDecodedString(str2));
        
	String str3 = "2[a2[b]]";
        System.out.println(getDecodedString(str3));
        
	String str4 = "2[a3[c]]";
        System.out.println(getDecodedString(str4));*/
        
	String str5 = "b2[ca]";
        System.out.println(getDecodedString(str5));
    }

    /**
     * @param str
     * @return
     */
    private static String getDecodedString(String str) {
	Stack<Integer> counts = new Stack<>();
	Stack<String> result = new Stack<>();
	String finalResult = "";
	int index = 0;
	
	while(index < str.length()) {
	    if(Character.isDigit(str.charAt(index))) {
		int count = 0;
		while(Character.isDigit(str.charAt(index))) {
		    count = 10 * count + (str.charAt(index) - '0');
		    System.out.println(count);
		    index += 1;
		}
		counts.push(count);
	    }
	    else if(str.charAt(index) == '[') {
		result.push(finalResult);
		finalResult = "";
		index += 1;
	    }
	    else if(str.charAt(index) == ']') {
		StringBuilder temp = new StringBuilder(result.pop());
		int count = counts.pop();
		for(int i=0; i <count; i++) {
		    temp.append(finalResult);
		}
		finalResult = temp.toString();
		index += 1;
	    }
	    else {
		finalResult += str.charAt(index);
		index += 1;
	    }
	}
	
	return finalResult;
    }

}
