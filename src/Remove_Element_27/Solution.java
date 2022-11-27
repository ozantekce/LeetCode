package Remove_Element_27;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int [] nums = {3,2,2,3};
        System.out.println(removeElement(nums,3));
        System.out.println(Arrays.toString(nums));
    }


    public static int removeElement(int[] nums,int val) {

        int index =0;
        for (int i = 0; i <= nums.length-1; i++) {
            if(nums[i]!=val){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

}
