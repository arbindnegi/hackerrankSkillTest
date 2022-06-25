/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 19-Jun-2022
 *
 */
public class Full_Binarry_Tree_Print {

    public static void main(String[] args) {

/** Construct the following tree
	        20
	      /   \
	     /     \
	    8      22
	   / \      
	  /   \    
	 4    12 
	      / \      
	     /   \    
	   10    14
	  
Answer: 12,8 and 20

**/
	Node root = new Node(20);
	root.left = new Node(8);
	root.right = new Node(22);
	root.left.left = new Node(4);
	root.left.right = new Node(12);
	root.left.right.right = new Node(14);
	root.left.right.left = new Node(10);

	find_Full_Binary_Tree(root);
    }

 /** 
  * prints all nodes that have both children as non-empty. 
  * **/ 
  
    private static void find_Full_Binary_Tree(Node node) {
        if(node!=null) {
            find_Full_Binary_Tree(node.left);
            find_Full_Binary_Tree(node.right);
            
            if(node.left !=null && node.right !=null) {
        	System.out.print(node.data+" ");
            }
        }
    }
}

class Node {

    int data;
    Node left, right;

    Node(int d) {
	data = d;
	left = right = null;
    }
}
