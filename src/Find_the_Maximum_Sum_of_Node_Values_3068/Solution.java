package Find_the_Maximum_Sum_of_Node_Values_3068;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maximumValueSum(new int[]{1,2,1},3,new int[][]{{0,1},{0,2}}));
        System.out.println(maximumValueSum(new int[]{7,7,7,7,7,7},3,new int[][]{{0,1},{0,2},{0,3},{0,4},{0,5}}));

    }


    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;


        long totalIncrease = 0;
        int countOfPositiveValues = 0;

        int minPositiveValue = Integer.MAX_VALUE;
        int maxNonPositiveValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int increase = ((nums[i] ^ k) - nums[i]);
            if(increase > 0){
                countOfPositiveValues++;
                totalIncrease += increase;
                minPositiveValue = Math.min(minPositiveValue, increase);
            }else{
                maxNonPositiveValue = Math.max(maxNonPositiveValue, increase);
            }
        }

        if(countOfPositiveValues % 2 == 0){
            return total + totalIncrease;
        }

        long res1 = total + totalIncrease - minPositiveValue;
        long res2 = total + totalIncrease + maxNonPositiveValue;

        return  Math.max(res1, res2);

    }





}
