package Maximum_Number_of_Moves_in_a_Grid_2684;

public class Solution {


    public static void main(String[] args) {



    }

    private static int [][] Moves = new int[][]{{-1,1},{0,1},{1,1}};
    private static int [][] Memory;
    public static int maxMoves(int[][] grid) {

        int res = 0;
        Memory = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            res = Math.max(res, recursive(grid, i, 0));
        }
        return res;
    }



    private static int recursive(int[][] grid, int row, int col){

        if(Memory[row][col] != 0)
            return Memory[row][col];

        int currentVal = grid[row][col];
        int maxMoves = 0;
        for (int i = 0; i < Moves.length; i++) {
            int[] move = Moves[i];
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length){
                int nextVal = grid[nextRow][nextCol];
                if(nextVal > currentVal){
                    int moves = 1 + recursive(grid, nextRow, nextCol);
                    maxMoves = Math.max(maxMoves, moves);
                }
                //int val = recursive(grid, row, col);
            }
        }

        Memory[row][col] = maxMoves;
        return maxMoves;
    }



}
