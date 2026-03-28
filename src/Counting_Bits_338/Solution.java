package Counting_Bits_338;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(countBits(4)));
        System.out.println(Arrays.toString(countBits(4)));
        
    }
    
    public static int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
                
        int curr = 0;
        int next = 2;
        for (int i = 1; i <= n; i++) {
            if(next <= i){
                curr = next;
                next <<= 1;
            }
            result[i] = 1 + result[i - curr];
        }
        
        return result;
    }
    
}
