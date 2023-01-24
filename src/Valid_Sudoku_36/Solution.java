package Valid_Sudoku_36;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {


    }


    public static boolean isValidSudoku(char[][] board) {

        char dot = '.';
        List<Character>[] cols = new ArrayList[9];
        List<Character>[] sqrs = new ArrayList[9];

        List<Character> row = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            row.clear();
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!=dot){
                    int r = i;
                    int c = j;
                    int s = squares[r][c];

                    if (row.contains(board[i][j])){return false;}
                    else{row.add(board[i][j]);}

                    if(cols[c]==null){cols[c] = new ArrayList<>(9); cols[c].add(board[i][j]);}
                    else if (cols[c].contains(board[i][j])){return false;}
                    else{cols[c].add(board[i][j]);}

                    if(sqrs[s]==null){sqrs[s] = new ArrayList<>(9); sqrs[s].add(board[i][j]);}
                    else if (sqrs[s].contains(board[i][j])){return false;}
                    else{sqrs[s].add(board[i][j]);}
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




}
