package Largest_Number_After_Digit_Swaps_by_Parity_2231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {


    public static void main(String[] args) {


        System.out.println(largestInteger(247));

    }

    public static int largestInteger(int num) {

        int oddSize = 0;
        int evenSize = 0;

        int size =0;
        int temp = num;
        while (temp>0){
            int d = temp%10;
            if(d%2==0){
                evenSize++;
            }else{
                oddSize++;
            }
            temp/=10;
            size++;
        }

        int [] evens = new int[evenSize];
        int [] odds = new int[oddSize];

        boolean [] isEven = new boolean[size];

        int o = 0,e = 0;
        int i = 0;
        while (num>0){
            int d = num%10;
            if(d%2==0){
                evens[e] = d;
                e++;
                isEven[i] = true;
            }else{
                odds[o] = d;
                o++;
                isEven[i] = false;
            }
            num/=10;
            i++;
        }

        Arrays.sort(evens);
        Arrays.sort(odds);

        o = 0;e = 0;
        int value = 0;
        int m = 1;
        for (int j = 0; j < size; j++) {
            if(isEven[j]){
                value += m * evens[e];
                e++;
            }else{
                value += m * odds[o];
                o++;
            }
            m*=10;
        }

        return value;
    }



}
