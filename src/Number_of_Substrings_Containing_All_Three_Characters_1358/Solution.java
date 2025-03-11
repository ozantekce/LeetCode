package Number_of_Substrings_Containing_All_Three_Characters_1358;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        //System.out.println(numberOfSubstrings("aaacb"));
    }


    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int[][] positions = new int[3][n];
        positions[0][n - 1] = positions[1][n - 1] = positions[2][n - 1] = -1;

        char c = s.charAt(n - 1);
        positions[c - 'a'][n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            c = s.charAt(i);
            positions[0][i] = positions[0][i + 1];
            positions[1][i] = positions[1][i + 1];
            positions[2][i] = positions[2][i + 1];

            positions[c - 'a'][i] = i;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int minPos = -1;
            for (int j = 0; j < 3; j++) {
                if (positions[j][i] == -1) {
                    minPos = -1;
                    break;
                } else if (positions[j][i] > minPos) {
                    minPos = positions[j][i];
                }
            }
            if (minPos == -1) break;
            res += n - minPos;
        }
        return res;
    }

}
