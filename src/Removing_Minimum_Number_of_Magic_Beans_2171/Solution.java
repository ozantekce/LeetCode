package Removing_Minimum_Number_of_Magic_Beans_2171;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        System.out.println(minimumRemoval(new int[]{4,1,6,5}));
    }


    public static long minimumRemoval(int[] beans) {
        
        Arrays.sort(beans);
        //1 4 5  6
        //1 5 10 16

        long [] sums = new long[beans.length];
        sums[0] = beans[0];
        for (int i = 1; i < beans.length; i++) {
            sums[i] = sums[i-1]+beans[i];
        }

        long totalSum = sums[sums.length-1];
        long nL = sums.length;
        long min = totalSum - sums[0] - ( (nL-1) * beans[0]);

        for (int i = 1; i < beans.length; i++) {
            //long cost = sums[i-1] + sums[n] - sums[i] - ((nL - i) * beans[i]);
            // (sums[i-1] - sums[i]) = -(beans[i])
            // - beans[i] - ((nL - i) * beans[i]) -> -beans[i]*(nL-i+1)
            long cost = totalSum - beans[i]*(nL-i);
            min = Math.min(min,cost);
        }

        return min;
    }


}
