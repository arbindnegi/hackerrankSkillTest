/**
 * 
 */
package hackerrank.advanced.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Arbind Negi 19-Jun-2022
 *
 */
public class LongestIncrementalSeqence {

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] arr =  {10, 22, 9, 33, 21, 50, 41, 60};
	System.out.println(getLongestIncrementalSeq(arr));
    }

    private static List<Integer> getLongestIncrementalSeq(int[] input) {
	List<Integer> result = new LinkedList<>();
	List<Integer> notRequired = new ArrayList<>();
	
	int i, j, count = 0;
	//result.add(input[nextPtr]);
	/* Initialize LIS values for all indexes */
	
	for (i = 1; i < input.length; i++) {
	    count = 0;
	    for (j = 0; j <= i; j++) {
	        if(input[i] > input[j] 
	        	&& !result.contains(input[j])
	        	&& !notRequired.contains(input[j])) {
	            
	            result.add(input[j]);
	            count +=1;
	        }
	        else if(input[input.length - 1] == input[i]
	        	&& !result.contains(input[j])
	        	&& !notRequired.contains(input[j])) {
	            
	            result.add(input[j]);
	        }
	    }
	    if(count == 0) {
		notRequired.add(input[i]);
	    }
	}
	
	return result;
    }

}
