package Plus_One_66;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] digits ={9,9,9,9};

        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));

    }

    public static int[] plusOne(int[] digits) {

        digits[digits.length-1]++;
        for (int i = 2; i <= digits.length; i++) {
            int last = digits[digits.length-i+1];
            if(last!=10){
                return digits;
            }
            digits[digits.length-i+1] = 0;
            digits[digits.length-i]++;
        }

        if(digits[0]!=10){
            return digits;
        }else{
            digits[0] = 0;
            int array[] = new int[digits.length+1];
            System.arraycopy(digits,0,array,1,digits.length);
            array[0] = 1;
            return array;
        }

    }
}
