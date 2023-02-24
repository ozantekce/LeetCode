package Minimum_Cost_of_Buying_Candies_With_Discount_2144;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        System.out.println(minimumCost(new int[]{6,5,7,9,2,2}));
        System.out.println(minimumCost(new int[]{1,2,3}));

    }

    public static int minimumCost(int[] cost) {

        Arrays.sort(cost);
        int rst = 0;
        int skip = 0;
        for (int i = cost.length-1; i >= 0; i--) {
            skip++;
            rst+=cost[i];
            if(skip==2){
                skip = 0;
                i--;
            }
        }

        return rst;
    }


}
