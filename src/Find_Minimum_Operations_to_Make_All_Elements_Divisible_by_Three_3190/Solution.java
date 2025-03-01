package Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three_3190;

public class Solution {


    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 2, 3, 4}));
    }

    public static int minimumOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] % 3;
            res += Math.min(a, (3 - a));
        }
        return res;
    }


}
