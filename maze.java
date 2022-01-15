package com.BackTracking;

import java.util.ArrayList;

public class maze {
    public static void main(String[] args) {
        //System.out.println(count(3,3));
        //path("",3,3);
        //System.out.println(pathDiagonal("",3,3));
        boolean [][] board ={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathRestrictions("",board,0,0);

    }

    public static int count(int r, int c)
    {
        if(r == 1 || c == 1 )
        {
            return 1;
        }

        int left = count(r-1,c); // answer getting from left, decreased row by 1
        int right = count(r,c-1); // answer getting from right, decreased col by 1

        return left+right;
    }

    public static void path(String p, int r,int c)
    {
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if(r > 1){
            path(p + 'D',r-1,c);
        }

        if( c > 1){
            path(p + 'R', r,c-1);
        }
    }

    //path as a list
    public static ArrayList<String> pathAsList(String p, int r, int c)
    {
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1){
            list.addAll(pathAsList(p + 'D',r-1,c));
        }

        if( c > 1){
            list.addAll(pathAsList(p + 'R', r,c-1));
        }

        return list;
    }

    //Now go ->only adds one recursive call only
    public static ArrayList<String> pathDiagonal (String p, int r, int c)
    {
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(r > 1){
            list.addAll(pathDiagonal(p + 'V',r-1,c));
        }

        if( c > 1){
            list.addAll(pathDiagonal( p + 'H', r,c-1));
        }
        //daigonally
        if( c > 1 && r > 1){
            list.addAll(pathDiagonal( p + 'D', r-1,c-1));
        }

        return list;
    }

    //Path Restriction
    public static void pathRestrictions(String p,boolean [][] maze, int r,int c)
    {
        if(r == maze.length - 1 && c == maze[0].length -1){ //base condition will be at the corner most
            System.out.println(p);
            return;
        }
        if (!maze [r][c]){
            return ;
        }
        if(r < maze.length - 1){
            pathRestrictions(p + 'D',maze,r+1,c);
        }

        if( c < maze[0].length - 1){
            pathRestrictions(p + 'R',maze, r,c+1);
        }
    }

}
