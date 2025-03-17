package Divide_Array_Into_Equal_Pairs_2206;

public class Solution {


    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));
    }


    public static boolean divideArray(int[] nums) {
        int[] counter = new int[501];

        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (counter[nums[i]] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
