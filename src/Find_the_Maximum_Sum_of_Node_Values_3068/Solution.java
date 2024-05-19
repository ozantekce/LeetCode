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
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        Int2 [] flippeds = new Int2[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flippeds[i] = new Int2(nums[i], (nums[i] ^ k));
        }
        Arrays.sort(flippeds);

        long res = total;
        for (int i = 0; i < flippeds.length && i+1 < flippeds.length; i+=2) {

            long temp = res - flippeds[i].oldValue + flippeds[i].newValue
                    - flippeds[i+1].oldValue + flippeds[i+1].newValue;

            if(temp > res){
                res = temp;
            }else{
                return res;
            }

        }

        return res;
    }

    private static class Int2 implements Comparable<Int2>
    {
        public int oldValue;
        public int newValue;

        public Int2(int oldValue, int newValue) {
            this.oldValue = oldValue;
            this.newValue = newValue;
        }

        @Override
        public int compareTo(Int2 o) {
            return -Integer.compare((newValue - oldValue), (o.newValue - o.oldValue));
        }
    }




}
