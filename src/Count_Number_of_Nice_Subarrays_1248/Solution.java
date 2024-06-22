package Count_Number_of_Nice_Subarrays_1248;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1},3));
        //System.out.println(numberOfSubarrays(new int[]{2,4,6},1));
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2));

    }


    public static int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }

        int [] prefSums = new int[n];
        prefSums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefSums[i] = prefSums[i-1] + nums[i];
        }

        //System.out.println(Arrays.toString(prefSums));
        int [] prefSumCounts = new int[prefSums[n-1] + 1];
        for (int i = 0; i < n; i++) {
            prefSumCounts[prefSums[i]]++;
        }
        //System.out.println(Arrays.toString(prefSumCounts));

        int res = 0;
        for (int i = 0; i < n; i++) {
            if(prefSums[i] == k){
                res++;
            }
            int need = prefSums[i] - k;

            if(need >= 0){
                res += prefSumCounts[need];
                if(need == prefSums[i])
                    res--;
            }


        }

        return res;
    }


}
