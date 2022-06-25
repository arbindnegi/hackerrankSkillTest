/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 19-Jun-2022
 *
 */
public class Max_Hight_Binary_tree {

    static class Node {

	int data;
	Node left, right;

	Node(int data) {
	    this.data = data;
	    left = right = null;
	}
    }

    public static void main(String[] args) {
/** Construct the following tree
        20           ----- level 1 (Odd)
      /   \           
     /     \
    8      22        ----- level 2 (Even)
   / \      
  /   \    
 4    12             ----- level 3 (Odd)
      / \      
     /   \    
   10    14         ----- level 4 (Even)
  
Answer: 4
Odd level data: 20 4 12

**/
	Node root = new Node(20);
	root.left = new Node(8);
	root.right = new Node(22);
	root.left.left = new Node(4);
	root.left.right = new Node(12);
	root.left.right.right = new Node(14);
	root.left.right.left = new Node(10);
	//find_Hight_Binary_Tree(root);
	System.out.println("Height of tree is : " +find_Hight_Binary_Tree(root));
	
	//This method is use to find all the alternate node or odd nodes
	// Result = 20 4 12
	printOddNodes(root, true);
    }

    private static int find_Hight_Binary_Tree(Node root) {
	if (root == null) {
	    return 0;
	} else {
	    int lTreeDepth = find_Hight_Binary_Tree(root.left);
	    int rTreeDepth = find_Hight_Binary_Tree(root.right);

	    if (lTreeDepth > rTreeDepth) {
		return lTreeDepth + 1;

	    } else {
		return rTreeDepth + 1;
	    }

	}

    }
    
    static void printOddNodes(Node root, boolean isOdd)
    {
        // If empty tree
        if (root == null)
        return;
     
        // If current node is of odd level
        if (isOdd == true)
        System.out.print(root.data + " ");
     
        // Recur for children with isOdd
        // switched.
        printOddNodes(root.left, !isOdd);
        printOddNodes(root.right, !isOdd);
    }
}
