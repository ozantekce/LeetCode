package Sign_of_the_Product_of_an_Array_1822;

public class Solution {


    public static int arraySign(int[] nums) {

        int negativeCount = 0;
        for (int num : nums) {
            if(num == 0)
                return 0;
            else if(num < 0)
                negativeCount++;
        }

        return negativeCount % 2 == 1 ? -1 : 1;
    }

}
