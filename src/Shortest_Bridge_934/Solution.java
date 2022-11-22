package Shortest_Bridge_934;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        int grid[][] = {
                {0,1},
                {1,0},
        };

        System.out.println(shortestBridge(grid));
    }


    public static int shortestBridge(int[][] grid) {
        int firstOneI=-1;
        int firstOneJ=-1;
        first:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    firstOneI = i;
                    firstOneJ = j;
                    break first;
                }
            }
        }
        firstIsland = new boolean[grid.length][grid[0].length];
        firstIsland[firstOneI][firstOneJ] = true;
        grid[firstOneI][firstOneJ] = 0;
        findFirstIsland(firstOneI,firstOneJ,grid);

        int current = 1;
        whileLoop:
        while (true){
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j]==current){
                        if(firstIsland[i][j]){
                            break whileLoop;
                        }
                        sendValueToNeighbors(i,j,grid,current+1);
                    }
                }
            }
            current++;
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(firstIsland[i][j]&&grid[i][j]!=0){
                    if(min>grid[i][j]){
                        min = grid[i][j];
                    }
                }
            }
        }
        return min-2;
    }

    public static boolean firstIsland [][];
    public static void findFirstIsland(int i,int j,int[][] grid){
        // Right
        int rightI = i;
        int rightJ = j+1;
        if(rightJ<grid[0].length){
            if(grid[rightI][rightJ]==1&&firstIsland[rightI][rightJ]==false){
                firstIsland[rightI][rightJ] = true;
                grid[rightI][rightJ] = 0;
                findFirstIsland(rightI,rightJ,grid);
            }
        }
        // Left
        int leftI = i;
        int leftJ = j-1;
        if(leftJ>=0){
            if(grid[leftI][leftJ]==1&&firstIsland[leftI][leftJ]==false){
                firstIsland[leftI][leftJ] = true;
                grid[leftI][leftJ] = 0;
                findFirstIsland(leftI,leftJ,grid);
            }
        }
        // Up
        int upI = i-1;
        int upJ = j;
        if(upI>=0){
            if(grid[upI][upJ]==1&&firstIsland[upI][upJ]==false){
                firstIsland[upI][upJ] = true;
                grid[upI][upJ] = 0;
                findFirstIsland(upI,upJ,grid);
            }
        }
        // Down
        int downI = i+1;
        int downJ = j;
        if(downI<grid.length){
            if(grid[downI][downJ]==1&&firstIsland[downI][downJ]==false){
                firstIsland[downI][downJ] = true;
                grid[downI][downJ] = 0;
                findFirstIsland(downI,downJ,grid);
            }
        }
    }
    public static void sendValueToNeighbors(int i,int j,int[][] grid,int value){
        // Right
        int rightI = i;
        int rightJ = j+1;
        if(rightJ<grid[0].length){
            if(grid[rightI][rightJ]==0){
                grid[rightI][rightJ] = value;
                //sendValueToNeighbors(rightI,rightJ,grid,value);
            }
        }
        // Left
        int leftI = i;
        int leftJ = j-1;
        if(leftJ>=0){
            if(grid[leftI][leftJ]==0){
                grid[leftI][leftJ] = value;
                //sendValueToNeighbors(leftI,leftJ,grid,value);
            }
        }
        // Up
        int upI = i-1;
        int upJ = j;
        if(upI>=0){
            if(grid[upI][upJ]==0){
                grid[upI][upJ] = value;
                //sendValueToNeighbors(upI,upJ,grid,value);
            }
        }
        // Down
        int downI = i+1;
        int downJ = j;
        if(downI<grid.length){
            if(grid[downI][downJ]==0){
                grid[downI][downJ] = value;
                //sendValueToNeighbors(downI,downJ,grid,value);
            }
        }
    }

}
