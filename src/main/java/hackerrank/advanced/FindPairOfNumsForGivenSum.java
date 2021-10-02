/**
 * 
 */
package hackerrank.advanced;

/**
 * @author Arbind Negi 02-Oct-2021
 *
 */
public class FindPairOfNumsForGivenSum {

    public static void main(String[] args) {
	int [] numbers = {1,3,6,4,5,6,8};
	getpairOfNumbersForGivenSum(numbers, 9);
    }
    
    private static void getpairOfNumbersForGivenSum(int[] numbersArrays, int resultSum) {
	for(int i = 0 ; i < numbersArrays.length; i++) {
	    int firstElement = numbersArrays[i];
	    for(int j = i + 1 ; j < numbersArrays.length; j++) {
		 int nextElement = numbersArrays[j];
		 
		 if (firstElement + nextElement == resultSum) {
		     System.out.printf("(%d, %d) %n", firstElement, nextElement);
		 }
	    }
	}
    }
}
