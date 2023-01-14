package Relative_Sort_Array_1122;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {



    public static void main(String[] args) {

        int [] arr1  = {2,3,1,3,2,4,6,7,9,2,19};
        int [] arr2  = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));

    }



    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap<Integer,Integer> decoder = new HashMap<>();
        HashMap<Integer,Integer> counterDecoder = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            decoder.put(arr2[i], i);
            counterDecoder.put(i,arr2[i]);
        }

        for (int i = 0; i < arr1.length; i++) {
            if(decoder.containsKey(arr1[i])){
                arr1[i] = decoder.get(arr1[i]);
            }else{
                arr1[i]+=1001;
            }
        }
        Arrays.sort(arr1);

        for (int i = 0; i < arr1.length; i++) {
            if(counterDecoder.containsKey(arr1[i])){
                arr1[i] = counterDecoder.get(arr1[i]);
            }else{
                arr1[i]-=1001;
            }
        }



        return arr1;
    }

}
