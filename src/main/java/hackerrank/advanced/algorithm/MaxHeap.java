/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 23-Jun-2022
 *
 */
public class MaxHeap {

    private int [] Heap;
    private int size;
    private int maxSize;
    
    
    /**
     * @param heap
     * @param size
     * @param maxSize
     */
    public MaxHeap(int maxSize) {
	this.maxSize = maxSize;
	this.Heap = new int[this.maxSize];
	this.size = 0;
    }

    private int parent(int pos) { 
	return (pos - 1) / 2; 
	}
    
    // Returning left children
    private int leftChild(int pos) { 
	return (2 * pos) + 1; 
	}
 
    // Returning right children
    private int rightChild(int pos){ 
	return (2 * pos) + 2; 
	}
    
    // Swapping nodes
    private void swap(int firstPos, int nextPos) {
        int tmp;
        tmp = Heap[firstPos];
        Heap[firstPos] = Heap[nextPos];
        Heap[nextPos] = tmp;
    }
    
    /**
     *  Inserts a new element to max heap
     */
    public void insert(int element) {
	Heap[size] = element;
	int current = size;
	
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    /**
     * Remove any specific node from the Heap
     * 
     * @param element
     * @param new_val
     */
    private void deleteSpecificNode(int element, int new_val) {
	Heap[element]=new_val;
	
	while(element !=0 && Heap[parent(element)] > Heap[element])
        {
            swap(element,parent(element));
            element = parent(element);
        }
	size--;
	extractMax();
    }
    
    public void print() {
	for(int i = 0; i < size/2; i++ ) {
	    System.out.print("Parent Node is : " + Heap[i] );
	    
	    if(leftChild(i) < size) {
		System.out.print(" Left child Node is : " + Heap[leftChild(i)] );
	    }
	    
	    if(rightChild(i) <= size) {
		System.out.print(" Right child Node is : " + Heap[rightChild(i)] );
	    }
	    
	    System.out.println(); // Break the line
	}
    }
 
    // Remove an element from max heap
    public int extractMax() {
        int popped = Heap[0];
        Heap[0] = Heap[size];
        size=size-1;
        maxHeap(0);
        return popped;
    }
 
    // Recursive function to max heap given subtree
    private void maxHeap(int pos) {
        if (isLeaf(pos))
            return;
 
        if (Heap[pos] < Heap[leftChild(pos)]
            || Heap[pos] < Heap[rightChild(pos)]) {
 
            if (Heap[leftChild(pos)]
                > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeap(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeap(rightChild(pos));
            }
        }
    }
    
    // return TRUE, if the node is leaf of the tree
    private boolean isLeaf(int pos) {
	
	if(pos > size/2 && pos <= size)
	    return true;
	
	return false;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {

/** Construct the following tree
            84           -
          /   \           
         /     \
        22      19        
       / \      / \      
      /   \    /   \
     17    15 5     6      
    / \    /     
   /   \  10   
  3     9  

Time complexcity is O(Log n)
Note: For the case of MIN HEAP, it will be just the reverse of Max Heap
**/   
	MaxHeap maxHeap = new MaxHeap(15);

	// Inserting nodes
	maxHeap.insert(5);
	maxHeap.insert(3);
	maxHeap.insert(17);
	maxHeap.insert(10);
	maxHeap.insert(84);
	maxHeap.insert(19);
	maxHeap.insert(6);
	maxHeap.insert(22);
	maxHeap.insert(9);
	maxHeap.insert(15);
        
	maxHeap.print();
	
	System.out.println("The max val is " + maxHeap.extractMax());

	maxHeap.deleteSpecificNode(1, Integer.MIN_VALUE);
	
	//maxHeap.print();
    }

}
