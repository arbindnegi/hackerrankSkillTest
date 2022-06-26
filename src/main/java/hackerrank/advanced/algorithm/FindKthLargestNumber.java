/**
 * 
 */
package hackerrank.advanced.algorithm;

import java.util.Collections;
import java.util.Vector;

/**
 * @author Arbind Negi 27-Jun-2022
 *
 */
public class FindKthLargestNumber {

    // Stores all elements tree in PQ
    static Vector<Integer> pq = new Vector<Integer>();
	    
    static class Node {
	Node left, right;
	int data;
	
	public Node(int data) {
	   this.data = data;
	   this.left = this.right =null;
	}
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        root.right.left = new Node(6);
        int K = 3;
        
        int result = findKthLargestTree(root, K);
        System.out.println("Result of Kth element is :" + result);
    }
    
    /**
     * @param root
     * @param k
     * 
     * This Funtion is use to find the Larhest Kth element in the Queue
     */
    private static int findKthLargestTree(Node root, int k) {
	
	traverse(root);

	return findKthLargest(k);
	
	
    }

    private static void traverse(Node root) {
	
	if (root == null) {
            return;
        }
	
	//pushing the element into the priority Queue
	pq.add(root.data);
	
	Collections.sort(pq);
	Collections.reverse(pq);
	
	traverse(root.left);
	traverse(root.right);
    }
    
    /**
     * @param element
     */
    private static int findKthLargest(int element) {
	--element;
	
	while(element > 0 && pq.size() > 0) {
	    pq.remove(0);
	    --element;
	}
	 // If PQ is not empty then return the top element
        if (pq.size() > 0) {
            return pq.get(0);
        }
        
        // Otherwise, return -1
        return -1;
    }
    
}
