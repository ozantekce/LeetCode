package Minimum_Operations_to_Make_Array_Equal_1551;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minOperations(3));
        System.out.println(minOperations(6));

    }


    public static int minOperations(int n) {

        int last = 2*n - 1;
        int mid = ((last+1)/2);
        int ops = (((mid - 1)/2)+1) * (mid / 2);
        return ops;
    }


}
