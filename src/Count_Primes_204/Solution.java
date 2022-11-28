package Count_Primes_204;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countPrimes(10));

    }


    public static int countPrimes(int n) {
        if(n==0||n==1||n==2)
            return 0;
        if(n==3)
            return 1;
        int counter = 1;

        boolean ignore [] = new boolean[n+1];
        ignore[2] = true;
        for (int j = 0; j < n; j+=2) {
            ignore[j] = true;
        }
        for (int i = 2; i < n; i++) {
            if(ignore[i]){
                continue;
            }else{
                counter++;
                for (int j = 0; j < n; j+=i) {
                    ignore[j] = true;
                }
            }
        }

        return counter;
    }


}
