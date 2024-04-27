package Number_of_Unequal_Triplets_in_Array_2475;

import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

    }


    public static int unequalTriplets(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num0 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[j];
                if(num0 == num1)
                    continue;
                for (int k = j + 1; k < nums.length; k++) {
                    int num2 = nums[k];
                    if(num0 != num2 && num1 != num2){
                        res++;
                    }
                }

            }

        }

        return res;
    }

}
