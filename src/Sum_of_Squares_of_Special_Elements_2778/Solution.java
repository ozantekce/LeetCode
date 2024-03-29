package Sum_of_Squares_of_Special_Elements_2778;

public class Solution {


    public static void main(String[] args) {

        System.out.println(sumOfSquares(new int[] {1,2,3,4}));
        System.out.println(sumOfSquares(new int[] {2,7,1,19,18,3}));

    }



    public static int sumOfSquares(int[] nums) {

        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            int num = 0;
            if(n % (i+1) == 0){
                num = nums[i] * nums[i];
            }
            result += num;

        }

        return result;
    }

}
