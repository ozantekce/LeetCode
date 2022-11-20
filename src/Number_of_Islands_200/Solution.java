package Number_of_Islands_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        char [][] grid = {{'1','1','1'},
                          {'0','1','0'},
                          {'1','1','1'}
        };


        System.out.println(numIslands(grid));

    }


    public static int numIslands(char[][] grid) {

        int current = 2;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j]=='1'){
                    grid[i][j] = (char) (current+48);
                    current++;
                    sendValueToNeighbors(i,j,grid,(char)(current+48));
                }

            }
        }

        return current-2;
    }

    public static void sendValueToNeighbors(int i,int j,char[][] grid,char value){
        // Right
        int rightI = i;
        int rightJ = j+1;
        if(rightJ<grid[0].length){
            if(grid[rightI][rightJ]=='1'){
                grid[rightI][rightJ] = value;
                sendValueToNeighbors(rightI,rightJ,grid,value);
            }
        }
        // Left
        int leftI = i;
        int leftJ = j-1;
        if(leftJ>=0){
            if(grid[leftI][leftJ]=='1'){
                grid[leftI][leftJ] = value;
                sendValueToNeighbors(leftI,leftJ,grid,value);
            }
        }
        // Up
        int upI = i-1;
        int upJ = j;
        if(upI>=0){
            if(grid[upI][upJ]=='1'){
                grid[upI][upJ] = value;
                sendValueToNeighbors(upI,upJ,grid,value);
            }
        }
        // Down
        int downI = i+1;
        int downJ = j;
        if(downI<grid.length){
            if(grid[downI][downJ]=='1'){
                grid[downI][downJ] = value;
                sendValueToNeighbors(downI,downJ,grid,value);
            }
        }
    }

    public static boolean getValueFromNeighbors(int i,int j,char[][] grid){
        // Right
        int rightI = i;
        int rightJ = j+1;
        if(rightJ<grid[0].length){
            if(grid[rightI][rightJ]!='0'&&grid[rightI][rightJ]!='1'){
                grid[i][j] = grid[rightI][rightJ];
                return true;
            }
        }
        // Left
        int leftI = i;
        int leftJ = j-1;
        if(leftJ>=0){
            if(grid[leftI][leftJ]!='0'&&grid[leftI][leftJ]!='1'){
                grid[i][j] = grid[leftI][leftJ];
                return true;
            }
        }
        // Up
        int upI = i-1;
        int upJ = j;
        if(upI>=0){
            if(grid[upI][upJ]!='0'&&grid[upI][upJ]!='1'){
                grid[i][j] = grid[upI][upJ];
                return true;
            }
        }
        // Down
        int downI = i+1;
        int downJ = j;
        if(downI<grid.length){
            if(grid[downI][downJ]!='0'&&grid[downI][downJ]!='1'){
                grid[i][j] = grid[downI][downJ];
                return true;
            }
        }
        return false;
    }


    /*
    public static int numIslands(char[][] grid) {

        int colLength = grid[0].length;
        int rowLength = grid.length;
        int result = 0;
        for (int i = 0; i < rowLength; i++) {

            for (int j = 0; j < colLength; j++) {
                if(grid[i][j]=='1'){
                    visit(grid,j,i,colLength,rowLength);
                    result++;
                }
            }

        }

        return result;
    }

    public static void visit(char [][] grid,int col,int row,int colLength,int rowLength){

        List<Integer> visited = new ArrayList<>();
        Stack<Integer> frontier = new Stack<>();
        frontier.add(colRowToIndex(col,row,colLength));

        while (!frontier.isEmpty()){
            int index = frontier.pop();
            visited.add(index);
            int cCol = indexToCol(index,colLength);
            int cRow = indexToRow(index,colLength);

            int leftNeighbor_col,leftNeighbor_row;
            leftNeighbor_col = cCol-1;
            leftNeighbor_row = cRow;
            if(leftNeighbor_col>=0){
                int i = colRowToIndex(leftNeighbor_col,leftNeighbor_row,colLength);
                if(grid[leftNeighbor_row][leftNeighbor_col]=='1' &&!visited.contains(i)&&!frontier.contains(i))
                    frontier.add(i);
            }
            int rightNeighbor_col,rightNeighbor_row;
            rightNeighbor_col = cCol+1;
            rightNeighbor_row = cRow;
            if(rightNeighbor_col<colLength){
                int i = colRowToIndex(rightNeighbor_col,rightNeighbor_row,colLength);
                if(grid[rightNeighbor_row][rightNeighbor_col]=='1' &&!visited.contains(i)&&!frontier.contains(i))
                    frontier.add(i);
            }
            int upNeighbor_col,upNeighbor_row;
            upNeighbor_col = cCol;
            upNeighbor_row = cRow-1;
            if(upNeighbor_row>=0){
                int i = colRowToIndex(upNeighbor_col,upNeighbor_row,colLength);
                if(grid[upNeighbor_row][upNeighbor_col]=='1' &&!visited.contains(i)&&!frontier.contains(i))
                    frontier.add(i);
            }
            int downNeighbor_col,downNeighbor_row;
            downNeighbor_col = cCol;
            downNeighbor_row = cRow+1;
            if(downNeighbor_row<rowLength){
                int i = colRowToIndex(downNeighbor_col,downNeighbor_row,colLength);
                if(grid[downNeighbor_row][downNeighbor_col]=='1' &&!visited.contains(i)&&!frontier.contains(i))
                    frontier.add(i);
            }
            //System.out.println(frontier);
        }

        //System.out.println(visited);
        for (int i:visited) {
            int cCol = indexToCol(i,colLength);
            int rRow = indexToRow(i,colLength);
            grid[rRow][cCol] = '2';
        }

    }


    public static int colRowToIndex(int col,int row,int colLength){
        return row*colLength+col;
    }
    public static int indexToCol(int index,int colLength){
        return index%colLength;
    }
    public static int indexToRow(int index,int colLength){
        return index/colLength;
    }
*/
}
