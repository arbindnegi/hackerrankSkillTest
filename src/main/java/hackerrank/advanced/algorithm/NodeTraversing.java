/**
 * 
 */
package hackerrank.advanced.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Arbind Negi 13-Jun-2022
 *
 */
public class NodeTraversing {

    static class TreeNode {
        int data;
        TreeNode left, right;
 
        public TreeNode(int key) {
            data = key;
            left = right = null;
        }
    }
 
    /**
     * In pre-order traversal of a binary tree, we first traverse the root, then the left subtree and then finally the right subtree. 
     * 
     * @param treeNode
     */
    static void preorder(TreeNode treeNode) {
        if (treeNode == null)
            return;
 
        // Traverse root DFS (Depth First Search)
        System.out.print(treeNode.data + " ");
        // Traverse left
        preorder(treeNode.left);
        // Traverse right
        preorder(treeNode.right);
    }
 
    /**
     * In-order traversal of a binary tree first traverses the left subtree then the root and finally the right subtree. 
     * 
     * @param treeNode
     */
    static void inorder(TreeNode treeNode) {
        if (treeNode == null)
            return;
 
        // Traverse left DFS (Depth First Search)
        inorder(treeNode.left);
        // Traverse root
        System.out.print(treeNode.data + " ");
        // Traverse right
        inorder(treeNode.right);
    }

    /**
     * Post-order traversal of a binary tree first traverses the left subtree then the right subtree and then finally the root. 
     * 
     * @param treeNode
     */
    static void postorder(TreeNode treeNode) {
        if (treeNode == null)
            return;
 
        // Traverse left DFS (Depth First Search)
        postorder(treeNode.left);
        // Traverse right
        postorder(treeNode.right);
        // Traverse root
        System.out.print(treeNode.data + " ");
    }
 
    /**
     * Level order traversal uses a queue to keep track of nodes to visit. After visiting a node, 
     * its children are put in the queue. To get a new node to traverse, we take out elements from the queue 
     * @param treeNode
     */
   //BFS (Breadth-First Search )
   static void printLevelOrder(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root);
       while (!queue.isEmpty()) {
           TreeNode tempNode = queue.poll();
           System.out.print(tempNode.data + " ");
 
           /*add left child to the queue */
           if (tempNode.left != null) {
               queue.add(tempNode.left);
           }
 
           /*add right right child to the queue */
           if (tempNode.right != null) {
               queue.add(tempNode.right);
           }
       }
   }
 
    public static void main(String args[])
             
    {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println("Inorder traversal");
        inorder(root);
 
        System.out.println("\nPreorder traversal ");
        preorder(root);
 
        System.out.println("\nPostorder traversal");
       postorder(root);
 
        System.out.println("\nLevelorder traversal");
        printLevelOrder(root);
 
    }
}
