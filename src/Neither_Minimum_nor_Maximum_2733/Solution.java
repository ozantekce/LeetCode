package Neither_Minimum_nor_Maximum_2733;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(findNonMinOrMax(new int[]{3,2,1,4}));
        //System.out.println(findNonMinOrMax(new int[]{1,2}));
        //System.out.println(findNonMinOrMax(new int[]{2,1,3}));
        System.out.println(findNonMinOrMax(new int[]{3,30,24}));

    }


    public static int findNonMinOrMax(int[] nums) {

        if(nums.length<=2) return -1;
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        return a + b + c - Math.max(Math.max(a, b), c) - Math.min(Math.min(a, b), c);

    }


}
