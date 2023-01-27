package Partition_Array_Into_Three_Parts_With_Equal_Sum_1013;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        System.out.println(canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));

    }


    public static boolean canThreePartsEqualSum(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        if(sum%3!=0){
            return false;
        }
        int target = sum/3;
        int currentSum = 0;
        int counter = 0;
        int i =0;
        for (i = 0; i < arr.length; i++) {
            currentSum+=arr[i];
            if(currentSum==target && counter<2){
                counter++;
                currentSum=0;
                if(counter==2){
                    if(i==arr.length-1){
                        i = arr.length;
                    }
                    break;
                }
            }
        }
        int remainder = sum - 2*target;
        System.out.println(remainder+" "+i);
        if(counter==2 &&remainder==target && i!=arr.length){
            return true;
        }else{
            return false;
        }

    }



}
