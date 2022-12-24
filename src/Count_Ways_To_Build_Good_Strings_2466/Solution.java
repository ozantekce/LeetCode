package Count_Ways_To_Build_Good_Strings_2466;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {

        System.out.println(countGoodStrings(1,100000,1,1));

    }



    public static int countGoodStrings(int low, int high, int zero, int one) {

        int DP[] = new int[high+1];

        DP[0] = 0;
        DP[zero] += 1;
        DP[one]  += 1;
        int mod = 1000000007;

        int sum =0 ;

        for (int i = 1; i <= high; i++) {
            if(i+zero<=high){
                DP[i+zero] += DP[i];
                DP[i+zero] %=mod;
            }
            if(i+one<=high){
                DP[i+one] += DP[i];
                DP[i+one] %=mod;
            }

            if(i>=low){
                sum+= DP[i];
                sum%=mod;
            }

        }
        return sum;
    }

}
