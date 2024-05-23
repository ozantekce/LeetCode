package The_Number_of_Beautiful_Subsets_2597;

public class Solution {


    public static void main(String[] args) {

        System.out.println(beautifulSubsets(new int[]{2,4,6},2));

    }


    public static int beautifulSubsets(int[] nums, int k) {
        return recursive(nums,new int[nums.length],0,0,k);
    }


    private static int recursive(int[] nums, int[] array,int i, int size, int k){

        if(i>=nums.length)
            return 0;

        int res = 0;
        for (; i < nums.length; i++) {
            array[size++] = nums[i];
            if(isbeautiful(array, size, k)){
                res++;
                res += recursive(nums, array, i+1, size, k);
            }
            size--;
        }
        return res;
    }



    private static boolean isbeautiful(int[] nums, int size, int k){
        for (int j = 0; j < size-1; j++) {
            int diff = Math.abs(nums[j] - nums[size-1]);
            if(diff == k)
                return false;
        }
        return true;
    }


}
