package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 27-Aug-2021
 *
 */
public class BinarySearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
	BinarySearch binSearch = new BinarySearch();
	int arr[] = {2,3,4,10,20,50};
        int length = arr.length;
        int searchElement = 10;
        int resultResursive = binSearch.getBinarySearchRecursiveApproch(arr, 0, length -1, searchElement);
        System.out.println("Result from resursive approch found Element at index: " + resultResursive);
        
        
        int resultIttrationApproch = binSearch.getBinarySearchIteratively(arr, 0, length -1, searchElement);
        System.out.println("Result from Iterative approch found Element at index: " + resultIttrationApproch);
        
    }
   
    //Binary Search has a space complexity of O(log N) with recursive 
    public int getBinarySearchRecursiveApproch (int arr[] , int left, int right, int searchElement) {
	if (right >= left) {
	    int mid = left + (right -left)/2;
	    
	    if(arr[mid] == searchElement) {
		return mid;
	    }
	    
	    if (arr[mid] > searchElement) {
		return getBinarySearchRecursiveApproch(arr , left , mid - 1, searchElement);
	    }
	    else {
		return getBinarySearchRecursiveApproch(arr , mid + 1 ,right, searchElement);
	    }
	}
	
	return - 1;
    }
    
    
    //time complexity is O ( N * log ( N ) )
    public int getBinarySearchIteratively(int[] sortedArray, int left, int right, int searchElement) {
	      int index = Integer.MAX_VALUE;
	      
	      while (left <= right) {
	          int mid = left  + ((right - left) / 2);
	          if (sortedArray[mid] < searchElement) {
	              left = mid + 1;
	          } else if (sortedArray[mid] > searchElement) {
	              right = mid - 1;
	          } else if (sortedArray[mid] == searchElement) {
	              index = mid;
	              break;
	          }
	      }
	      return index;
	  }

}
