/**
 * 
 */
package hackerrank.advanced.algorithm;

/**
 * @author Arbind Negi 25-Jun-2022
 * Problem Statement : The queen’s movement is that no two queens can be in the same row or column or
 * No Queen can be attack to other Queen Either Diagonal, Left or Right.
 * 
 * Solution: All the Queen placement should be in the the Safe place.
 */
public class NQueen_Solution {
    final int N = 4;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	NQueen_Solution nQueen = new NQueen_Solution();
	
	int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
 
        if (!nQueen.getNQueenSolve(board, 0)) {
            System.out.print("Solution does not exist");
            return;
        }
        
        for (int i = 0; i < nQueen.N; i++) {
            for (int j = 0; j < nQueen.N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }

    }
    
    private boolean getNQueenSolve(int board [][], int column) {

	if (column >= N)
            return true;
	
	/* Consider this column and try placing this queen in all rows one by one */
	for(int i = 0; i < N; i++) {
	    if(isSafe(board, i, column)) {
		/* Place this queen in board[i][column] */
                board[i][column] = 1;
                
                /* recursive call to place rest of the queens */
                if (getNQueenSolve(board, column + 1))
                    return true;
                
                /* If placing queen in board[i][column] doesn't lead to a solution then remove queen from board[i][column] & start BACKTRACK*/
                   board[i][column] = 0; // BACKTRACK
	    }
	}
	
	return false;
    }
    
    private boolean isSafe(int board [][], int row, int column) {
	//Check this row in the left side of all the columns 
	for(int i=0; i < column; i++) {
	    if(board[row][i] == 1)
		return false;
	}
	
	/* Check the upper diagonal on the left side */
	for(int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
	    if(board[i][j] == 1)
		return false;
	}
	
	//check the lower diagonal on the left side
	for(int i = row, j = column; i < N && j >= 0; i++, j--) {
	    if(board[i][j] == 1)
		return false;
	}
	
	return true;
    }

}
