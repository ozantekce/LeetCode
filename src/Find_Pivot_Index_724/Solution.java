package Find_Pivot_Index_724;

public class Solution {


    public static void main(String[] args) {


        int [] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));

    }


    public static int pivotIndex(int[] nums) {

        int left = nums[0];
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right+=nums[i];
        }
        if(left==right){
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            left+=nums[i];
            right-=nums[i-1];
            if(left==right){
                return i;
            }
        }


        return -1;
    }

}
