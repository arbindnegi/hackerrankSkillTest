/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 16-Jun-2022
 *
 */
public class LargestSumSubArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [] elements = {-2, 10, -5, -6, 2, 4, 9, -5, 1};
        
        System.out.println("Sum of largest subarray: " +findLargestSum(elements));
    }
    
    private static int findLargestSum(int [] input) {
	if(input.length < 1)
	    return 0;
	
	int currentMax = input[0];
	int finalMax = input[0];
	
	for(int i = 1; i < input.length; i++) {
	    if(currentMax < 0) {
		currentMax = input[i];
	    }
	    else {
		currentMax += input[i];
	    }
	
            if(finalMax < currentMax) {
        	finalMax = currentMax;
            }  
	}
	
	return finalMax;
    }

}
