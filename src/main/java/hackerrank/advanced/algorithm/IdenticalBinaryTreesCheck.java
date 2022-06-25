/**
 * 
 */
package hackerrank.advanced.algorithm;


/**
 * @author Arbind Negi 16-Jun-2022
 *
 */
public class IdenticalBinaryTreesCheck {

    static class TreeNode {
        int data;
        TreeNode left, right;
 
        public TreeNode(int key) {
            data = key;
            left = right = null;
        }
    }
    
    public static void main(String[] args) {
   	TreeNode binaryTree1 = new TreeNode(20);
   	binaryTree1.left = new TreeNode(50);
   	binaryTree1.right = new TreeNode(200);
   	binaryTree1.left.left = new TreeNode(75);
   	binaryTree1.left.right = new TreeNode(25);
   	binaryTree1.right.right = new TreeNode(300);
        
   	TreeNode binaryTree2 = new TreeNode(20);
   	binaryTree2.left = new TreeNode(50);
   	binaryTree2.right = new TreeNode(200);
   	binaryTree2.left.left = new TreeNode(75);
   	binaryTree2.left.right = new TreeNode(25);
   	binaryTree2.right.right = new TreeNode(300);
   	
   	if(isIdenticalBinaryTree(binaryTree1, binaryTree2)) {
   	    System.out.println("Both the tree are same");
   	}
   	else {
   	 System.out.println("Both the tree are different");
   	}
       }
    
    private static boolean isIdenticalBinaryTree(TreeNode tree1, TreeNode tree2) {
	
	    if(tree1 ==null && tree2 ==null ) {
	        return true;
	    }
	    
	if(tree1 !=null && tree2 !=null ) {
	    
	    return ((tree1.data == tree2.data) &&
		    isIdenticalBinaryTree(tree1.left, tree2.left ) &&
		    isIdenticalBinaryTree(tree1.right, tree2.right));
	}

	return false;
    }
}
