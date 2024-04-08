package Largest_Number_179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(largestNumber(new int[]{10,2}));
        //System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        //System.out.println(largestNumber(new int[]{34323,3432}));
        //System.out.println(largestNumber(new int[]{432,43243}));
        System.out.println(largestNumber(new int[]{999999998,999999997,999999999}));

    }

    public static String largestNumber(int[] nums) {

        Num[] array = new Num[nums.length];
        boolean allZero = true;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0)
                allZero = false;
            array[i] = new Num(nums[i]);
        }
        if(allZero)
            return "0";
        Arrays.sort(array);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i].num);
        }
        return stringBuilder.toString();
    }


    private static class Num implements Comparable<Num>{

        private int num;
        private int mainVal;
        private long pow;

        public Num(int n) {
            this.num = n;
            pow = 10;
            while (n >= 10){
                n /= 10;
                pow *= 10;
            }
            mainVal = n;
        }


        @Override
        public int compareTo(Num o) {

            if(mainVal > o.mainVal)
                return -1;
            else if(mainVal < o.mainVal)
                return +1;

            long v0 = num * o.pow + o.num;
            long v1 = o.num * pow + num;

            if(v0 > v1)
                return -1;
            else if(v0 < v1)
                return +1;

            return 0;

        }

    }

}
