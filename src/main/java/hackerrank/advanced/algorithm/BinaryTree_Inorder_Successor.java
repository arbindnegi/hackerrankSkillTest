/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 19-Jun-2022
 *
 */
public class BinaryTree_Inorder_Successor {

    static Node head;

    static class Node {

	int data;
	Node left, right, parent;

	Node(int d) {
	    data = d;
	    left = right = parent = null;
	}
    }

    /**
     * Given a binary search tree and a number, inserts a new node with the given
     * number in the correct place in the tree. Returns the new root pointer which
     * the caller should then use
     **/
    Node insert(Node node, int data) {

	/*
	 * 1. If the tree is empty, return a new, single node
	 */
	if (node == null) {
	    return (new Node(data));
	} else {

	    Node temp = null;

	    /* 2. Otherwise, recur down the tree */
	    if (data <= node.data) {
		temp = insert(node.left, data);
		node.left = temp;
		temp.parent = node;
	    } else {
		temp = insert(node.right, data);
		node.right = temp;
		temp.parent = node;
	    }

	    /* return the (unchanged) node pointer */
	    return node;
	}
    }

    Node inOrderBinaryTreeSuccessor(Node root, Node inputNode) {

	if (inputNode.right != null) {
	    return getMostLeftleaf(inputNode.right);
	}

	Node parent = inputNode.parent;
	while (parent != null && inputNode == parent.right) {
	    inputNode = parent;
	    parent = parent.parent;
	}
	return parent;
    }

    /**
     * Given a non-empty binary search tree, return the minimum data value found in
     * that tree. Note that the entire tree does not need to be searched.
     **/
    Node getMostLeftleaf(Node node) {
	/* loop down to find the leftmost leaf */
	if (node.left == null) {
	    return node;
	}

	return getMostLeftleaf(node.left);

    }

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

**/
	BinaryTree_Inorder_Successor tree = new BinaryTree_Inorder_Successor();
	Node root = null, requestNode = null, result = null;
	root = tree.insert(root, 20);
	root = tree.insert(root, 8);
	root = tree.insert(root, 22);
	root = tree.insert(root, 4);
	root = tree.insert(root, 12);
	root = tree.insert(root, 10);
	root = tree.insert(root, 14);
	requestNode = root.left.right;
	result = tree.inOrderBinaryTreeSuccessor(root, requestNode);
	if (result != null) {
	    System.out.println("Inorder successor of " + requestNode.data + " is " + result.data);
	} else {
	    System.out.println("Inorder successor does not exist");
	}
    }

}
