package N_th_Tribonacci_Number_1137;

public class Solution {


    public static void main(String[] args) {

        System.out.println(tribonacci(8));

    }

    public static int tribonacci(int n) {

        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;

        int DP[] = new int[n+1];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 1;

        for (int i = 3; i <= n; i++) {
            DP[i] = DP[i-1]+DP[i-2]+DP[i-3];
        }

        return DP[n];
    }


}
