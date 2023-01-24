package Valid_Sudoku_36;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {


    }


    public static boolean isValidSudoku(char[][] board) {

        char dot = '.';
        Checker[] cols = new Checker[9];
        Checker[] sqrs = new Checker[9];

        Checker row = new Checker();
        for (int i = 0; i < 9; i++) {
            row.clear();
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!=dot){

                    int s = squares[i][j];
                    int val = (board[i][j]-49);
                    if(!row.add(val)){
                        return false;
                    }

                    if(cols[j]==null){cols[j] = new Checker();}
                    if(!cols[j].add(val))
                        return false;

                    if(sqrs[s]==null){sqrs[s] = new Checker();}
                    if(!sqrs[s].add(val))
                        return false;
                }
            }

        }

        return true;
    }

    {
        configurations();
    }
    private static boolean isConfigured;
    private static int [][] squares;
    private static void configurations(){
        if(isConfigured){
            return;
        }
        System.out.println("configurations");
        isConfigured = true;
        squares = new int[9][9];
        int [][] ss = new int[][]{
                {0, 1, 2, 9, 10, 11, 18, 19, 20},
                {3, 4, 5, 12, 13, 14, 21, 22, 23},
                {6, 7, 8, 15, 16, 17, 24, 25, 26},
                {27, 28, 29, 36, 37, 38, 45, 46, 47},
                {30, 31, 32, 39, 40, 41, 48, 49, 50},
                {33, 34, 35, 42, 43, 44, 51, 52, 53},
                {54, 55, 56, 63, 64, 65, 72, 73, 74},
                {57, 58, 59, 66, 67, 68, 75, 76, 77},
                {60, 61, 62, 69, 70, 71, 78, 79, 80}
        };
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int index = ss[i][j];
                int r = index/9;
                int c = index%9;
                squares[r][c] = i;
            }
        }

    }


    private static class Checker{

        boolean [] values;
        public Checker(){
            values = new boolean[9];
        }

        public boolean add(int val){
            if(values[val])
                return false;
            values[val] = true;
            return true;
        }

        public void clear(){
            for (int i = 0; i < 9; i++) {
                values[i] = false;
            }
        }


    }


}
