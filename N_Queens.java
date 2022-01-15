package com.BackTracking;

public class N_Queens {
    public static void main(String[] args) {
        int n=4;
           boolean[][] board= new boolean[n][n];
        System.out.println(queens(board,0));
    }
    static int queens(boolean [][] board , int row){
        if(row == board.length) //base condn->all the queens has been placed
        {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        //placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            //isSafe function will check that is this row or col do not contain any queen + no queen in this diagonal
            if(isSafe(board,row,col)){
                board[row][col] = true; //means if safe we have put the queen on that place
                count += queens(board,row + 1); // now moving on to next row to put the next other queen
                board[row][col] = false; // change it back to normal
            }
            
        }
        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]){ //means a queen is there, not safe to place it
                return false;
            }
        }
        //diagonal left
        int maxLeft = Math.min(row,col); //maximum time u can go left is the ,min of row and col
        for (int i = 1; i <= maxLeft ; i++) {//subtarcting 1, till the maximum left we have to go
            if(board[row-i][col-i]){  // as we go left row and col both decreases
                return false;
            }
        }

        //diagonal right
        int maxRight = Math.min(row,board.length - col - 1); //maximum time u can go left is the ,min of row and col
        for (int i = 1; i <= maxRight ; i++) { //subtarcting 1, till the maximum right we have to go
            if(board[row-i][col+i]){  // as we go left row and col both decreases
                return false;
            }
        }

        //if none of the cae return false,return true then..means u can place the queen at there
        return true;
    }

    public static void display(boolean[][] board) {
        for(boolean[] row : board){ //for every row in my board
            for(boolean element : row){ //for every element in my row
                if(element){ //if element is true then print Q
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
