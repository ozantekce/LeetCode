package Kth_Missing_Positive_Number_1539;

import java.util.Arrays;

public class Solution {



    public static void main(String[] args) {

        int [] array = {1,2,3,4};
        System.out.println(findKthPositive(array,2));

    }


    public static int findKthPositive(int[] arr, int k) {

        int counter = 0;
        for (int i = 1; i <= arr[arr.length-1]+k; i++) {

            int index = Arrays.binarySearch(arr,i);
            if(index<0){
                counter++;
            }else{
                i = arr[index];
            }
            if(counter>=k){
                return i;
            }
        }

        return -1;
    }


}
