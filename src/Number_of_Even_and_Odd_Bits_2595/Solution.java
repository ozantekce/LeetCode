package Number_of_Even_and_Odd_Bits_2595;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(evenOddBit(17)));
        System.out.println(Arrays.toString(evenOddBit(2)));

    }



    private static final int[] multiplesOfTwo = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512};

    public static int[] evenOddBit(int n) {

        int[] result = new int[2];
        for (int i = multiplesOfTwo.length-1; i >= 0; i--) {

            if(n >= multiplesOfTwo[i]){
                n-= multiplesOfTwo[i];
                if(i%2 == 0){
                    result[0]++;
                }else{
                    result[1]++;
                }
                if(n<=0){
                    break;
                }
            }

        }

        return result;
    }




}
