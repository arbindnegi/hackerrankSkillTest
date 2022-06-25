/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 16-Jun-2022
 *
 */
public class MirrorImageBinaryTreeSolution {

    static class TreeNode {
        int data;
        TreeNode left, right;
 
        public TreeNode(int key) {
            data = key;
            left = right = null;
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	TreeNode nods = new TreeNode(20);
	nods.left = new TreeNode(50);
	nods.right = new TreeNode(200);
	nods.left.left = new TreeNode(75);
	nods.left.right = new TreeNode(25);
	nods.right.right = new TreeNode(300);
        getMirrorImageBT(nods);
        
        preorder(nods);
    }
    
     private static void getMirrorImageBT(TreeNode treeNode) {
	
	if(treeNode == null)
	    return;
	
	getMirrorImageBT(treeNode.left);
	
	getMirrorImageBT(treeNode.right);
	
	TreeNode temp = treeNode.left;
	treeNode.left = treeNode.right;
	treeNode.right = temp;
	
    }
     
  // Method to perform preorder traversal for binary tree
     /**
      * In pre-order traversal of a binary tree, we first traverse the root, then the left subtree and then finally the right subtree. 
      * 
      * @param treeNode
      */
     
     private static void preorder(TreeNode treeNode)
     {
         if (treeNode == null) {
             return;
         }
  
         System.out.print(treeNode.data + " ");
         preorder(treeNode.left);
         preorder(treeNode.right);
     }

}
