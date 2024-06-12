package Sort_Colors_75;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        sortColors(new int[]{2,0,2,1,1,0});
        sortColors(new int[]{2,0,1});

    }


    public static void sortColors(int[] nums) {

        int size = 0;
        for (int target = 0; target < 3; target++) {
            for (int i = size; i < nums.length; i++) {
                if(nums[i] == target){
                    int temp = nums[i];
                    nums[i] = nums[size];
                    nums[size++] = temp;
                }
            }
        }

    }

}
