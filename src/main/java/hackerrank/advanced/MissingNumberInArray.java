/**
 * 
 */
package hackerrank.advanced;

/**
 * @author Arbind Negi 02-Oct-2021
 *
 */
public class MissingNumberInArray {
    /**
     * 
     */
    public static void main(String[] args) {
	int[] numberMissingInArray = {1,5,7};
	printMissingElements(numberMissingInArray, numberMissingInArray.length);
    }

    static void printMissingElements(int arr[], int N) {

        // Initialize startValue : this value will be the initial value for to began
	int startElement = arr[0] - 0;
	for (int i = 0; i < N; i++) {
        // Check if startValue and arr[i]-i, both are equal or not
	if (arr[i] - i != startElement) {
        // finding all the missing elements
            while (startElement < arr[i] - i) {
		    System.out.print((i + startElement) + " ");
		    startElement++;
		}
	    }
	}
    }

}
