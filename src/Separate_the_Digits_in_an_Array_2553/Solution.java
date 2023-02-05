package Separate_the_Digits_in_an_Array_2553;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(separateDigits(new int[]{13,25,83,77})));

    }

    public static int[] separateDigits(int[] nums) {

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            size+=findSize(nums[i]);
        }

        int [] array = new int[size];
        for (int i = 0,j=0; i < nums.length; i++) {
            int val = nums[i];
            int start = j;
            int end;
            while (val>0){
                array[j] = val%10;
                val/=10;
                j++;
            }
            end = j;
            reverseArray(array,start,end-1);

        }

        return array;
    }

    public static void reverseArray(int array[],int start, int end)
    {
        int half = start + ((end + 1) - start) / 2;
        int endCount = end;
        for (int startCount = start; startCount < half; startCount++) {
            int store = array[startCount];
            array[startCount] = array[endCount];
            array[endCount] = store;
            endCount--;
        }
    }

    public static int findSize(int val){

        int size = 0;
        while (val>0){
            size++;
            val/=10;
        }
        return size;
    }
}
