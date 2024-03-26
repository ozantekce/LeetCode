package Sort_Array_By_Parity_905;

import java.util.Arrays;

public class Solution {



    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{0})));

    }




    public static int[] sortArrayByParity(int[] nums) {

        int [] result = new int[nums.length];
        int evenPointer = 0;
        int oddPointer = nums.length-1;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            boolean isEven = num % 2 == 0;

            if(isEven){
                result[evenPointer++] = num;
            }else{
                result[oddPointer--] = num;
            }
        }


        return result;
    }


}
