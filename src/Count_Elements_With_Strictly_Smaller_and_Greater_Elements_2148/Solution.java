package Count_Elements_With_Strictly_Smaller_and_Greater_Elements_2148;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countElements(new int []{11,7,2,15}));
        System.out.println(countElements(new int []{-3,3,3,90}));
        System.out.println(countElements(new int []{3,3,3,3}));

    }


    public static int countElements(int[] nums) {

        int min = nums[0];
        int minCounter = 1;

        int max = nums[0];
        int maxCounter = 1;

        for (int i = 1; i < nums.length; i++) {

            int val = nums[i];

            if(val < min){
                min = val;
                minCounter = 1;
            }else if(val == min){
                minCounter++;
            }

            if(val > max){
                max = val;
                maxCounter = 1;
            }else if(val == max){
                maxCounter++;
            }

        }

        if(min == max) return 0;

        return nums.length - minCounter - maxCounter;
    }

}
