package Special_Array_I_3151;

public class Solution {


    public static void main(String[] args) {

        System.out.println(isArraySpecial(new int[]{1}));
        System.out.println(isArraySpecial(new int[]{2, 1, 4}));
        System.out.println(isArraySpecial(new int[]{4, 3, 1, 6}));

    }


    public static boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == nums[i] % 2) return false;
        }
        return true;
    }

}
