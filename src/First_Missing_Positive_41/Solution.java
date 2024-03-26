package First_Missing_Positive_41;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{1}));

    }



    public static int firstMissingPositive(int[] nums) {

        // 1,2,3...X       => X+1
        // 1,2,3...X,Y,... => X+1
        // Y,...           => 1
        // X <= n

        int n = nums.length;
        boolean trivial = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 1){
                trivial = false;
            }
            if(num<=0 || num>n){
                nums[i] = n+1;
            }
        }

        if(trivial)
            return 1;
        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num > n)
                continue;
            num = Math.abs(num)-1;
            //System.out.println("num : " + num);
            if(num < n && nums[num] > 0){
                nums[num] *= -1;
            }
        }

        //System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >=0)
                return i+1;
        }

        return n+1;
    }

}
