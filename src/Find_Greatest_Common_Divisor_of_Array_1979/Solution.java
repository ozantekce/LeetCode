package Find_Greatest_Common_Divisor_of_Array_1979;

public class Solution {



    public static int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }


        return gcdBySteinsAlgorithm(min,max);
    }

    static int gcdBySteinsAlgorithm(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }

        if (n2 == 0) {
            return n1;
        }

        int n;
        for (n = 0; ((n1 | n2) & 1) == 0; n++) {
            n1 >>= 1;
            n2 >>= 1;
        }

        while ((n1 & 1) == 0) {
            n1 >>= 1;
        }

        do {
            while ((n2 & 1) == 0) {
                n2 >>= 1;
            }

            if (n1 > n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            n2 = (n2 - n1);
        } while (n2 != 0);
        return n1 << n;
    }
}
