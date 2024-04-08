package Smallest_Value_of_the_Rearranged_Number_2165;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(smallestNumber(310));
        System.out.println(smallestNumber(-7605));

    }



    public static long smallestNumber(long num) {

        boolean positive = num > 0;
        if(!positive){
            num *= -1;
        }
        long temp = num;
        int size = 0;
        while (temp>0){
            size++;
            temp/=10;
        }
        byte [] array = new byte[size];
        int i = size - 1;
        while (num>0){
            array[i--] = (byte) (num%10);
            num/=10;
        }

        long result = 0;
        Arrays.sort(array);
        //System.out.println(Arrays.toString(array));

        if(positive){

            for (int j = 0; j < array.length; j++) {
                byte b = array[j];
                if(b != 0){
                    result = b;
                    array[j] = 10;
                    break;
                }
            }
            long mul = 10;
            for (int j = 0; j < array.length; j++) {
                byte b = array[j];
                if(b == 10) continue;
                result *= mul;
                result += b;
            }

        }else{
            long mul = 1;
            for (int j = 0; j < array.length; j++) {
                result += array[j] * mul;
                mul *= 10;
            }
            result *= -1;
        }

        return result;
    }

}
