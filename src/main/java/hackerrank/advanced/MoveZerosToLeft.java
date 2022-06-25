/**
 * 
 */
package hackerrank.advanced;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Arbind Negi 15-Jun-2022
 *
 */
public class MoveZerosToLeft {
    
    public static void main(String[] args) {
	    int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
	    System.out.println("Original Array: " + Arrays.toString(v));
	    
	    moveZerosToLeft(v);
	    
	    System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
	    //elementList.forEach(i -> System.out.println(i)); 
	  } 
    
    static void moveZerosToLeft(int[] A) {
	    if (A.length < 1) {
	      return;
	    }

	    int writeIndex = A.length - 1;
	    int readIndex = A.length - 1;

	    while(readIndex >= 0) {
	      if(A[readIndex] != 0) {
	        A[writeIndex] = A[readIndex];
	        writeIndex--;
	      }

	      readIndex--;
	    }

	    while(writeIndex >= 0) {
	      A[writeIndex] = 0;
	      writeIndex--;
	    }
	  }
}
