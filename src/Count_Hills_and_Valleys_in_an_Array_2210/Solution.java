package Count_Hills_and_Valleys_in_an_Array_2210;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
        System.out.println(countHillValley(new int[]{6, 6, 5, 5, 4, 1}));

    }


    public static int countHillValley(int[] nums) {

        int beforeType = 0;
        int counter = 0;
        for (int i = 1; i < nums.length - 1; i++) {

            int mid = nums[i];

            int left = -1;
            for (int j = i; j >= 0; j--) {
                if (mid != nums[j]) {
                    left = nums[j];
                    break;
                }
            }

            if (left == -1) {
                beforeType = 0;
                continue;
            }

            int right = -1;
            for (int j = i; j < nums.length; j++) {
                if (mid != nums[j]) {
                    right = nums[j];
                    break;
                }
            }

            if (right == -1) {
                beforeType = 0;
                continue;
            }

            boolean isHill = mid > left && mid > right;
            boolean isValley = mid < left && mid < right;

            if (isHill) {
                //System.out.println("i: " + i + " " + "hill");
                if (beforeType != 1) counter++;
                beforeType = 1;
            } else if (isValley) {
                //System.out.println("i: " + i + " " + "valley");
                if (beforeType != 2) counter++;
                beforeType = 2;
            } else {
                beforeType = 0;
            }


        }

        return counter;
    }


}
