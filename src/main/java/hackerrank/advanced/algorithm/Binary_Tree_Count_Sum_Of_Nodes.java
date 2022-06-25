/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 22-Jun-2022
 *
 */
public class Binary_Tree_Count_Sum_Of_Nodes {

    static class Node {

	int data;
	Node left, right;

	Node(int d) {
	    data = d;
	    left = right = null;
	}
    }
    /**
     * @param args
     */
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
  
Answer: 
Count of Binary Tree Nodes: 7
Count of Binary Tree Nodes: 90
Maximum Hight of Tree:4
**/
	Node root = new Node(20);
	root.left = new Node(8);
	root.right = new Node(22);
	root.left.left = new Node(4);
	root.left.right = new Node(12);
	root.left.right.right = new Node(14);
	root.left.right.left = new Node(10);
        
	System.out.println("Count of Binary Tree Nodes: " + getCountOfBinaryTreeNodes(root));
	
	System.out.println("Sum of Binary Tree Nodes: " + getSumOfBinaryTreeNodes(root));
	
	System.out.println("Maximum Hight of Tree:" + getMax_Hight_BinaryTree(root));
    }
    
    private static int getCountOfBinaryTreeNodes(Node root) {
	
	if(root == null) {
	    return 0;
	}
	
	int leftCount = getCountOfBinaryTreeNodes(root.left);
	int rightCount = getCountOfBinaryTreeNodes(root.right);
	
	return leftCount + rightCount + 1;
    }
    
    private static int getSumOfBinaryTreeNodes(Node root) {
	
	if(root == null) {
	    return 0;
	}
	
	int leftSum = getSumOfBinaryTreeNodes(root.left);
	int rightSum = getSumOfBinaryTreeNodes(root.right);
	
	return leftSum + rightSum + root.data;
    }
    
    private static int getMax_Hight_BinaryTree(Node root) {
	
	if(root == null) {
	    return 0;
	}
	
	int leftHight = getMax_Hight_BinaryTree(root.left);
	int rightHight = getMax_Hight_BinaryTree(root.right);
	
	return Math.max(leftHight, rightHight) + 1;
    }
    
}
