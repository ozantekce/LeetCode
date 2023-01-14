package Reduction_Operations_to_Make_the_Array_Elements_Equal_1887;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution {


    public static void main(String[] args) {

        int nums [] = new int[]{5,1,3};

        System.out.println(reductionOperations(nums));

    }

    public static int reductionOperations(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        int currentElement = nums[0];
        int numberOfCurrentElements = 1;
        int multiply = 0;
        for (int i = 1; i < nums.length; i++) {

            if(currentElement == nums[i]){
                numberOfCurrentElements++;
            }else{
                sum += multiply * numberOfCurrentElements;
                currentElement = nums[i];
                numberOfCurrentElements=1;
                multiply++;
            }

        }

        sum += multiply * numberOfCurrentElements;


        return sum;
    }


}
