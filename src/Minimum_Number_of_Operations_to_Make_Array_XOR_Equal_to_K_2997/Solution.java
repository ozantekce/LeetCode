package Minimum_Number_of_Operations_to_Make_Array_XOR_Equal_to_K_2997;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{2,1,3,4},1));
        //System.out.println(minOperations(new int[]{2,0,2,0},0));
        System.out.println(minOperations(new int[]{9,7,9,14,8,6},12));

    }


    public static int minOperations(int[] nums, int k) {
        int c = 0;

        for (int num : nums) {
            c ^= num;
        }

        int xorResult = c ^ k;

        int res = 0;
        while (xorResult != 0) {
            res += xorResult & 1;
            xorResult >>= 1;
        }

        return res;
    }


}
