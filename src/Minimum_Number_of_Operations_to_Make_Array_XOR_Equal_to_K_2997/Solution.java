package Minimum_Number_of_Operations_to_Make_Array_XOR_Equal_to_K_2997;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{2,1,3,4},1));
        //System.out.println(minOperations(new int[]{2,0,2,0},0));
        System.out.println(minOperations(new int[]{9,7,9,14,8,6},12));

    }


    public static int minOperations(int[] nums, int k) {

        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            c ^= nums[i];
        }

        // 001
        // 100

        // 1100
        // 111

        String bitsK = Integer.toBinaryString(k);
        String bitsC = Integer.toBinaryString(c);

        int l = Math.max(bitsK.length(), bitsC.length());
        int res = 0;


        for (int i = 0; i < l; i++) {
            char bitC = i < bitsC.length() ? bitsC.charAt(bitsC.length() - 1 - i) : '0';
            char bitK = i < bitsK.length() ? bitsK.charAt(bitsK.length() - 1 - i) : '0';
            if(bitC != bitK){
                res++;
            }
        }

        return res;
    }

}
