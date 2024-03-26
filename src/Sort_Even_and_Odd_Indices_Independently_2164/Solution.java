package Sort_Even_and_Odd_Indices_Independently_2164;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortEvenOdd(new int[]{4,1,2,3})));
        //System.out.println(Arrays.toString(sortEvenOdd(new int[]{2,1})));

    }




    public static int[] sortEvenOdd(int[] nums) {

        int evenPointer = 0;
        int oddPointer = 0;

        int [] evens = new int[nums.length];
        int [] odds = new int[nums.length];

        for (int i = 0; i < nums.length; i+=2) {
            evens[evenPointer++] = nums[i];
        }
        for (int i = 1; i < nums.length; i+=2) {
            odds[oddPointer++] = nums[i];
        }

        Arrays.sort(evens,0,evenPointer);
        Arrays.sort(odds,0,oddPointer);


        for (int i = 0; i < evenPointer; i++) {
            nums[i*2] = evens[i];
        }
        for (int i = 0; i < oddPointer; i++) {
            nums[i*2+1] = odds[oddPointer - 1 - i];
        }

        return nums;
    }

}
