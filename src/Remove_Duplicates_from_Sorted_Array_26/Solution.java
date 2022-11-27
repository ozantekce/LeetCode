package Remove_Duplicates_from_Sorted_Array_26;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int [] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }


    public static int removeDuplicates(int[] nums) {

        int index =1;
        for (int i = 0; i <= nums.length-1; i++) {
            if(nums[index-1]!=nums[i]){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }


}
