package Number_of_Subarrays_With_GCD_Equal_to_K_2447;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(subarrayGCD(new int[]{9,3,1,2,6,3}, 3));
        System.out.println(subarrayGCD(new int[]{3,12,9,6}, 3));

    }



    public static int subarrayGCD(int[] nums, int k) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            if(gcd == k){
                res++;
            }
            for (int j = i+1; j < nums.length; j++) {
                gcd = gcdByEuclidsAlgorithm(nums[j], gcd);
                if(gcd == k){
                    res++;
                }else if(gcd < k){
                    break;
                }
            }
        }

        return res;
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

}
