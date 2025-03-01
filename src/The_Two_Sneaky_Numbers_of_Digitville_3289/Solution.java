package The_Two_Sneaky_Numbers_of_Digitville_3289;

public class Solution {


    public static void main(String[] args) {

    }

    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        boolean[] set = new boolean[101];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set[nums[i]]) {
                res[j++] = nums[i];
                if (j == 2) break;
            } else {
                set[nums[i]] = true;
            }
        }
        return res;
    }

}
