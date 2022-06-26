/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 26-Jun-2022
 *
 */
public class SortingAlgorithms {

    /**
     * @param args
     */
    public static void main(String[] args) {
	SortingAlgorithms ob = new SortingAlgorithms();
        int arr[] = {64,25,12,22,11};
        ob.insertionSort(arr);
        
        System.out.println("Insertion Sorted array:");
        for (int i=0; i<arr.length; ++i)
           System.out.print(arr[i]+" ");
        System.out.println();

        ob.bubbleSort(arr);
        System.out.println("Bubble Sorted array:");
        for (int i=0; i<arr.length; ++i)
           System.out.print(arr[i]+" ");
        
    }

    /**
     * @param arr
     */
    private void insertionSort(int[] arr) {
	for(int i =0 ; i< arr.length -1; i++) {
	    
	    int min_idx = i;
	    
	    for (int j = i+1; j < arr.length; j++) {
		if(arr[j] < arr[min_idx]) {
		    min_idx = j;
		 // Swap the found minimum element with the first element
		    int temp =  arr[min_idx];
		    arr[min_idx] = arr[i];
		    arr[i] = temp;
		}
	    }
	}
	
    }

    private void bubbleSort(int[] arr) {
	for(int i = 0; i < arr.length -1; i++) {
	    for(int j = 0; j < arr.length -i -1; j++) {
		if(arr[j] > arr[j + 1]) {
		    // Swap the found minimum element with the first element
		    int temp = arr[j];
		    arr[j] = arr[j + 1];
		    arr[j + 1] = temp;
		    
		}
	    }
	}
    }
}
