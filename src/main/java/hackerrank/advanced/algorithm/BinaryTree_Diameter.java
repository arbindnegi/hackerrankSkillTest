/**
 * 
 */
package hackerrank.advanced.algorithm;

import hackerrank.advanced.algorithm.Binary_Tree_Count_Sum_Of_Nodes.Node;

/**
 * @author Arbind Negi 23-Jun-2022
 *
 */
public class BinaryTree_Diameter {

    static class TreeInfo {
	int hight;
	int diameter;
	/**
	 * @param hight
	 * @param diameter
	 */
	public TreeInfo(int hight, int diameter) {
	    super();
	    this.hight = hight;
	    this.diameter = diameter;
	}
	
    }
    
    public static TreeInfo getBinaryTree_Diameter(Node root) {
	
	if(root == null) {
	    return new TreeInfo(0, 0);
	}
	
	TreeInfo leftTree = getBinaryTree_Diameter(root.left);
	
	TreeInfo rightTree = getBinaryTree_Diameter(root.right);
	//System.out.println(root.data);
	int treeHight = Math.max(leftTree.hight , rightTree.hight) + 1;
	
	int leftDiameter = leftTree.diameter;
	int rightDiameter = rightTree.diameter;
	int diameter =   leftTree.hight + rightTree.hight + 1;
	
	//System.out.println(leftDiameter + " " + rightDiameter);
	
	int finalDiameter = Math.max(Math.max(leftDiameter, rightDiameter),  diameter);
	
	return new TreeInfo(treeHight, finalDiameter);
    }
    
    public static void main(String [] str) {
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
  
Answer: 5
1-->14 or 10
2-->12
1-->8
1-->20
1-->22

**/
	Node root = new Node(20);
	root.left = new Node(8);
	root.right = new Node(22);
	root.left.left = new Node(4);
	root.left.right = new Node(12);
	root.left.right.right = new Node(14);
	root.left.right.left = new Node(10);
	
	System.out.println("Binary Tree diameter is : "+ getBinaryTree_Diameter(root).diameter);
    }
}
