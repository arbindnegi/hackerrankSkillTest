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
public class FindPairOfNumsForGivenSum {

    public static void main(String[] args) {
	int [] numbers = {1,3,6,4,5,6,8};
	getpairOfNumbersForGivenSum(numbers, 9);
	System.out.println("----------------------");
	getpairOfNumbersForGivenSumBestApproch(numbers, 9);
    }
 
    public static void getpairOfNumbersForGivenSumBestApproch(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            // if the difference is seen before, print the pair
            if (map.containsKey(target - nums[i]))
            {
                System.out.printf("Pair found with map implemantion (%d, %d) %n",
                    nums[map.get(target - nums[i])], nums[i]);
            }
 
            map.put(nums[i], i);
        }
    }
    
    private static void getpairOfNumbersForGivenSum(int[] numbersArrays, int resultSum) {
	for(int i = 0 ; i < numbersArrays.length; i++) {
	    int firstElement = numbersArrays[i];
	    for(int j = i + 1 ; j < numbersArrays.length; j++) {
		 int nextElement = numbersArrays[j];
		 
		 if (firstElement + nextElement == resultSum) {
		     System.out.printf("Pair found with normal implemantion (%d, %d) %n", firstElement, nextElement);
		 }
	    }
	}
    }
}