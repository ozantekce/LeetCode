package Sudoku_Solver_37;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        solveSudoku(new char[][]{
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        });

    }

    private static char [] initialString = new char[81];

    public static void solveSudoku(char[][] board) {
        Helper.Configurations();

        isFound = false;
        int index =0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c=='.')
                    c='0';
                initialString[index]=c;
                index++;
            }
        }

        Thread t1,t2;
        Solver s1,s2;
        s1 = new Solver(initialString,true);
        s2 = new Solver(initialString,false);
        t1 = new Thread(s1);
        t2 = new Thread(s2);
        t1.start();
        t2.start();

        While:
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!t1.isAlive()||!t2.isAlive())
                break;
        }
        index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = finalStr[index];
                index++;
            }
        }


    }

    private static char[] finalStr = new char[81];
    private static boolean isFound;
    private synchronized static void SetFinalString(char[] str)
    {
        if(isFound){
            return;
        }
        isFound = true;
        finalStr = Arrays.copyOf(str,str.length);
    }

    private static boolean Recursive(char[] str,int position,int[] array)
    {
        if (isFound)
        {
            return true;
        }

        if(position >= 81)
        {
            SetFinalString(str);
            return true;
        }

        if(str[position] != '0')
        {
            return Recursive(str, position+1, array);
        }

        for (int i = 0; i < array.length; i++)
        {
            if (Helper.IsValid(str,position,array[i]))
            {
                str[position] = (char)(array[i] + 48);
                if (Recursive(str, position + 1, array))
                {
                    return true;
                }
            }
        }
        str[position] = '0';

        return false;

    }

    private static boolean RecursiveBack(char[] str,int position,int[] array)
    {
        if (isFound)
        {
            return true;
        }

        if(position < 0)
        {
            SetFinalString(str);
            return true;
        }

        if(str[position] != '0')
        {
            return RecursiveBack(str, position-1, array);
        }

        for (int i = 0; i < array.length; i++)
        {
            if (Helper.IsValid(str,position,array[i]))
            {
                str[position] = (char)(array[i] + 48);
                if (RecursiveBack(str, position - 1, array))
                {
                    return true;
                }
            }
        }
        str[position] = '0';

        return false;

    }

    private static class Solver implements Runnable{

        private boolean type;
        private int [] array = new int[]{1,2,3,4,5,6,7,8,9};
        private char [] str;
        public Solver(char[] initial,boolean type){
            str = Arrays.copyOf(initial,initial.length);
            this.type = type;
        }

        @Override
        public void run() {

            if(type)
                Recursive(str,0,array);
            else
                RecursiveBack(str,80,array);
        }


    }


    private static class Helper
    {
        private static HashMap<Integer, Integer> rows;
        private static HashMap<Integer, Integer> cols;
        private static HashMap<Integer, Integer> sqrs;

        private static HashMap<Integer, List<Integer>> rowValues;
        private static HashMap<Integer, List<Integer>> colValues;
        private static HashMap<Integer, List<Integer>> sqrValues;


        private static boolean isConfigured;
        public static void Configurations()
        {
            if (isConfigured)
            {
                return;
            }
            isConfigured = true;


            tranform2D_1D = new HashMap<>(9);
            tranform1D_2D = new HashMap<>(81);
            for (int i = 0; i < 9; i++)
            {
                tranform2D_1D.put(i, new HashMap<>(9));
            }

            rows = new HashMap<>(9);
            cols = new HashMap<>(9);
            sqrs = new HashMap<>(9);


            int[][] ss = new int[][]{
                    new int[] {0, 1, 2, 9, 10, 11, 18, 19, 20},
                    new int[] {3, 4, 5, 12, 13, 14, 21, 22, 23},
                    new int[] {6, 7, 8, 15, 16, 17, 24, 25, 26},
                    new int[] {27, 28, 29, 36, 37, 38, 45, 46, 47},
                    new int[] {30, 31, 32, 39, 40, 41, 48, 49, 50},
                    new int[] {33, 34, 35, 42, 43, 44, 51, 52, 53},
                    new int[] {54, 55, 56, 63, 64, 65, 72, 73, 74},
                    new int[] {57, 58, 59, 66, 67, 68, 75, 76, 77},
                    new int[] {60, 61, 62, 69, 70, 71, 78, 79, 80}
            };

            rowValues = new HashMap<>(9);
            colValues = new HashMap<>(9);
            sqrValues = new HashMap<>(9);

            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    sqrs.put(ss[i][j],i);
                    int index = ss[i][j];
                    int r = GetRow(index);
                    int c = GetCol(index);
                    int s = i;
                    rows.put(i,r);
                    cols.put(j,c);

                    if (!rowValues.containsKey(r)){rowValues.put(r,new ArrayList<>(9));}
                    rowValues.get(r).add(index);
                    if (!colValues.containsKey(c)) { colValues.put(c, new ArrayList<>(9)); }
                    colValues.get(c).add(index);
                    if (!sqrValues.containsKey(s)) { sqrValues.put(s , new ArrayList<>(9)); }
                    sqrValues.get(s).add(index);

                }
            }

        }


        public static int GetSqr(int index)
        {
            return sqrs.get(index);
        }

        public static int GetRow(int index)
        {
            return Index1DTo2D(index)[0];
        }
        public static int GetCol(int index)
        {
            return Index1DTo2D(index)[1];
        }

        public static List<Integer> GetRowIndexes(int index)
        {
            return rowValues.get(GetRow(index));
        }

        public static List<Integer> GetColIndexes(int index)
        {
            return colValues.get(GetCol(index));
        }

        public static List<Integer> GetSqrIndexes(int index)
        {
            return sqrValues.get(GetSqr(index));
        }


        public static boolean IsValidGame(char[] board)
        {
            Checker rowChecker = new Checker();
            Checker [] colCheckers = new Checker [9];
            Checker [] sqrCheckers = new Checker [9];
            int index = 0;
            for (int i = 0; i < 9; i++)
            {
                rowChecker.Clear();
                for (int j = 0; j < 9; j++)
                {
                    if (!rowChecker.Add(board[index] - 48))
                    {
                        return false;
                    }
                    if (colCheckers[j] == null)
                    {
                        colCheckers[j] = new Checker ();
                    }
                    if (!colCheckers[j].Add(board[index] - 48))
                    {
                        return false;
                    }

                    if(sqrCheckers[GetSqr(index)] == null)
                    {
                        sqrCheckers[GetSqr(index)] = new Checker ();
                    }
                    if(!sqrCheckers[GetSqr(index)].Add(board[index] - 48))
                    {
                        return false;
                    }
                    index++;
                }
            }

            return true;
        }


        public static boolean IsValid(char[] str, int position, int val)
        {
            char newC = ((char)(val + 48));

            // Check rows
            for (int j : Helper.GetRowIndexes(position))
            {
                if (str[j] == newC)
                {
                    return false;
                }
            }

            // Check squares
            for (int j : Helper.GetSqrIndexes(position))
            {
                if (str[j] == newC)
                {
                    return false;
                }
            }

            // Check cols
            for (int j : Helper.GetColIndexes(position))
            {
                if (str[j] == newC)
                {
                    return false;
                }
            }


            return true;
        }


        private static HashMap<Integer, HashMap<Integer, Integer>> tranform2D_1D;
        private static HashMap<Integer, int[]> tranform1D_2D;
        public static int Index2DTo1D(int row, int col)
        {
            if (tranform2D_1D.get(row).containsKey(col))
            {
                return tranform2D_1D.get(row).get(col);
            }
            else
            {
                int value = row * 9 + col;
                tranform2D_1D.get(row).put(col,value);
                tranform1D_2D.put(value, new int[]{row,col});
                return value;
            }
        }

        public static int[] Index1DTo2D(int value)
        {

            if (tranform1D_2D.containsKey(value))
            {
                return tranform1D_2D.get(value);
            }
            else
            {
                int row = value / 9;
                int col = value % 9;
                tranform2D_1D.get(row).put(col,value);
                tranform1D_2D.put(value,new int[]{row,col});
                return tranform1D_2D.get(value);
            }
        }


        private static class Checker
        {

            private boolean[] values;

            public Checker()
            {
                values = new boolean[10];
            }

            public boolean Add(int val)
            {
                if (val == 0)
                    return true;
                if (values[val])
                    return false;
                values[val] = true;
                return true;
            }

            public void Clear()
            {
                values = new boolean[10];
            }

        }

    }




}
