package Rotating_the_Box_1861;


public class Solution {


    public static void main(String[] args) {

        char[][] res = rotateTheBox(new char[][]{{'#', '.', '#'}});
        for (int i = 0; i < res.length; i++) {
            //System.out.println(res[i]);
        }

        res = rotateTheBox(new char[][]{
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        });

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public static char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] result = new char[m][n];

        for (int i = 0; i < n; i++) {
            executeRow(boxGrid[i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = boxGrid[n - 1 - j][i];
            }
        }

        return result;
    }

    public static void executeRow(char[] row) {
        int n = row.length - 1;
        int t = -1;
        for (int i = n; i >= 0; i--) {
            char c = row[i];
            if (c == '.') {
                t = Math.max(t, i);
            } else if (c == '*') {
                t = -1;
            } else {
                if (t != -1 && t <= n) {
                    row[i] = '.';
                    row[t] = '#';
                    t--;
                }
            }
        }
    }

}
