package com.BackTracking;

public class All_Paths {
    public static void main(String[] args) {
        boolean [][] board ={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        AllPath("",board,0,0);
    }


    //BACKTRACKING- only two changes we made
    public static void AllPath(String p,boolean [][] maze, int r,int c)
    {
        if(r == maze.length - 1 && c == maze[0].length -1){ //base condition will be at the corner most
            System.out.println(p);
            return;
        }
        if (!maze [r][c]){
            return ;
        }
        // i am considering this block in my path
        maze[r][c] = false;

        if(r < maze.length - 1){
            AllPath(p + 'D',maze,r+1,c);
        }

        if( c < maze[0].length - 1){
            AllPath(p + 'R',maze, r,c+1);
        }
        if( r > 0){
            AllPath(p + 'U',maze, r-1,c);
        }
        if( c > 0){
            AllPath(p + 'L',maze, r,c-1);
        }

        //this lone is where the function will be over
        //so before the function gets  removed, also remove the changes that were made by that function
        maze[r][c]= true;
    }
}
