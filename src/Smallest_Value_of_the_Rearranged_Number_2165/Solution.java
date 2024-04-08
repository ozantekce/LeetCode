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

        byte[] counter = new byte[10];
        int minPositive = 10;
        while (num>0){
            int n = (int) (num%10);
            if(positive && minPositive != 1 && n < minPositive && n != 0) {
                minPositive = n;
            }
            counter[n]++;
            num/=10;
        }

        long result = 0;
        if(positive){
            counter[minPositive]--;
            result = minPositive;
            for (byte i = 0; i < counter.length; i++) {
                for (byte j = 0; j < counter[i]; j++) {
                    result*=10;
                    result+=i;
                }
            }
        }else{
            for (byte i = (byte) (counter.length - 1); i >= 0; i--) {
                for (byte j = 0; j < counter[i]; j++) {
                    result*=10;
                    result+=i;
                }
            }
        }

        return positive ? result : -result;
    }





}
