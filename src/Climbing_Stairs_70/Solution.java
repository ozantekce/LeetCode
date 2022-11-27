package Climbing_Stairs_70;

public class Solution {


    public static void main(String[] args) {

        int n = 8;
        System.out.println(climbStairs(n));

    }


    public static int climbStairs(int n) {

        int DP [] = new int[n+1];
        DP[0] = 1;
        for (int i = 0; i < DP.length-1; i++) {

            int f = i+1;
            int s = i+2;
            DP[f] += DP[i];
            if(s<=DP.length-1){
                DP[s] += DP[i];
            }

        }

        return DP[n];
    }


}
