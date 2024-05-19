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

        int [] increases = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            increases[i] = ((nums[i] ^ k) - nums[i]);
        }

        Arrays.sort(increases);

        long res = total;
        for (int i = increases.length-1; i-1 >= 0; i-=2) {

            long temp = res + increases[i] + increases[i-1];

            if(temp > res){
                res = temp;
            }else{
                return res;
            }

        }

        return res;
    }





}
