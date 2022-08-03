package Ugly_Number_II_264;

import java.util.ArrayList;
import java.util.List;

public class Solution_2 {

    // DP solution
    public static void main(String[] args) {

        long s;
        long f;
        System.out.println("-------------------------");
        s = System.currentTimeMillis();
        System.out.println(nthUglyNumber(1600));
        f = System.currentTimeMillis();
        System.out.println("time : "+(f-s));
    }

    public static int nthUglyNumber(int n) {

        int DP[] = new int[n+1];

        DP[0] = 1;
        DP[1] = 1;

        int pointer2 = 1, pointer3 = 1, pointer5 =1;
        int currentValue = 0;

        for (int i = 2; i < n+1; i++) {
            currentValue = Math.min(DP[pointer2]*2,Math.min(DP[pointer3]*3,DP[pointer5]*5));
            DP[i] = currentValue;
            if(DP[i] == DP[pointer2]*2){
                pointer2++;
            }
            if(DP[i] == DP[pointer3]*3){
                pointer3++;
            }
            if(DP[i] == DP[pointer5]*5){
                pointer5++;
            }
        }

        return DP[n];
    }


}
