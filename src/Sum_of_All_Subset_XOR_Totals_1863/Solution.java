package Sum_of_All_Subset_XOR_Totals_1863;

public class Solution {


    public static void main(String[] args) {

        System.out.println(subsetXORSum(new int[]{1,3}));
        System.out.println(subsetXORSum(new int[]{5,1,6}));

    }


    public static int subsetXORSum(int[] nums) {

        return findMax(nums, 0, 0);
    }

    private static int findMax(int[] nums, int value, int i){
        int selfValue = value;
        int res = 0;
        for (; i < nums.length; i++) {
            selfValue ^= nums[i];
            res += findMax(nums, selfValue, i+1);
            selfValue ^= nums[i];
        }
        return res + selfValue;
    }

}
