package Maximize_Happiness_of_Selected_Children_3075;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maximumHappinessSum(new int[]{1,2,3},2));
        System.out.println(maximumHappinessSum(new int[]{1,1,1,1},2));
        System.out.println(maximumHappinessSum(new int[]{2,3,4,5},1));

    }


    public static long maximumHappinessSum(int[] happiness, int k) {

        int n = happiness.length;
        long res = 0;
        Arrays.sort(happiness);

        for (int i = 0; i < k && i< happiness.length; i++) {
            int val = happiness[n - 1 - i] - i;
            if(val <= 0)
                break;
            res += val;
        }

        return res;
    }


}
