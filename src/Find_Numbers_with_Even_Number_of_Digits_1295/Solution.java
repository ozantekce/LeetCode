package Find_Numbers_with_Even_Number_of_Digits_1295;

public class Solution {

    public static void main(String[] args) {

    }


    public static int findNumbers(int[] nums) {

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitCount = 0;
            while (num > 0) {
                digitCount++;
                num /= 10;
            }
            if (digitCount % 2 == 0)
                res++;
        }

        return res;
    }

}
