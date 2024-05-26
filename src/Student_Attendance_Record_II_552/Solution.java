package Student_Attendance_Record_II_552;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(checkRecord(2));
        //System.out.println(checkRecord(1));
        //System.out.println(checkRecord(10));
        System.out.println(checkRecord(10101));

    }

    private static final int MOD = 1000000007;
    public static int checkRecord(int n) {

        int [][] prevRound = new int[2][3];
        int [][] nextRound = new int[2][3];

        prevRound[0][0] = 1;
        prevRound[1][0] = 1;
        prevRound[0][1] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if(prevRound[j][k] == 0)
                        continue;
                    nextRound[j][0] = (nextRound[j][0] + prevRound[j][k]) % MOD;
                    if(j+1 < 2) nextRound[j+1][0] = (nextRound[j+1][0] + prevRound[j][k]) % MOD;
                    if(k+1 < 3) nextRound[j][k+1] = (nextRound[j][k+1] + prevRound[j][k]) % MOD;
                }
            }
            int [][] temp = prevRound;
            prevRound = nextRound;
            nextRound = temp;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    nextRound[j][k] = 0;
                }
            }

        }

        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res =  (res + prevRound[i][j]) % MOD;
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
