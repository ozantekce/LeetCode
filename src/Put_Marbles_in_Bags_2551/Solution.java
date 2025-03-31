package Put_Marbles_in_Bags_2551;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {


    public static void main(String[] args) {

        System.out.println(putMarbles(new int[]{1, 3, 5, 1}, 2));
        System.out.println(putMarbles(new int[]{1, 3}, 2));
        System.out.println(putMarbles(new int[]{46, 37, 46, 17, 40, 50, 54, 11, 1, 25, 43, 21, 31, 29, 58, 49, 73, 54, 5, 52, 73, 54, 6, 22, 58, 9, 34, 21, 58, 68, 63}, 30));
        //System.out.println(putMarbles(new int[]{68, 65, 5, 74, 12, 67, 10, 55, 27, 38, 69, 54, 62, 50, 30, 3, 1, 24, 39, 65, 73, 33, 43, 9, 64}, 9));

    }


    public static long putMarbles(int[] weights, int k) {

        int[] partitionCosts = new int[weights.length];
        long baseCost = weights[0] + weights[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            partitionCosts[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(partitionCosts);

        long min = baseCost;
        int counter = k - 1;
        for (int i = 1; i < partitionCosts.length && counter > 0; i++) {
            min += partitionCosts[i];
            counter--;
        }

        long max = baseCost;
        counter = k - 1;
        for (int i = partitionCosts.length - 1; i >= 0 && counter > 0; i--) {
            max += partitionCosts[i];
            counter--;
        }

        return max - min;
    }


}
