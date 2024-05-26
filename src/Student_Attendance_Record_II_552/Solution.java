package Student_Attendance_Record_II_552;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(checkRecord(2));
        System.out.println(checkRecord(1));
        System.out.println(checkRecord(10101));

    }

    private static final int MOD = 1000000007;
    public static int checkRecord(int n) {

        int [][][] memory = new int[n+1][2][3];

        memory[1][0][0] = 1;
        memory[1][1][0] = 1;
        memory[1][0][1] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < 2; j++) {

                for (int k = 0; k < 3; k++) {

                    if(memory[i][j][k] == 0)
                        continue;
                    memory[i+1][j][0] =  (memory[i+1][j][0] + memory[i][j][k]) % MOD;
                    if(j+1 < 2) memory[i+1][j+1][0] = (memory[i+1][j+1][0] + memory[i][j][k]) % MOD;
                    if(k+1 < 3) memory[i+1][j][k+1] = (memory[i][j][k] + memory[i+1][j][k+1]) % MOD;
                }

            }

        }

        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res =  (res + memory[n][i][j]) % MOD;
            }
        }

        return res;
    }


    public static int recursive(int i, int n, int aCount, int lCount,int [][][] memory){

        if(aCount >= 2)
            return 0;
        if(lCount >= 3)
            return 0;
        if(i >= n)
            return 1;
        if(memory[i][aCount][lCount] != -1)
            return memory[i][aCount][lCount];

        int res = 0;
        res += recursive(i+1, n, aCount + 1 , 0, memory);
        res += recursive(i+1, n, aCount, lCount + 1, memory);
        res += recursive(i+1, n, aCount, 0, memory);

        memory[i][aCount][lCount] = res;
        return res;
    }




}
