package Find_the_Number_of_Good_Pairs_I_3162;

public class Solution {


    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                int num2 = nums2[j];
                if (num1 % (num2 * k) == 0) {
                    res++;
                }
            }
        }
        return res;
    }


}
