package Largest_Number_179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(largestNumber(new int[]{10,2}));
        //System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{34323,3432}));
        System.out.println(largestNumber(new int[]{432,43243}));

    }


    public static String largestNumber(int[] nums) {

        Num[] array = new Num[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = new Num(nums[i]);
        }
        Arrays.sort(array);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if(array[i].num == 0 && stringBuilder.isEmpty()) continue;
            stringBuilder.append(array[i].num);
        }
        if(stringBuilder.isEmpty() && array.length > 0)
            stringBuilder.append(0);
        return stringBuilder.toString();
    }


    private static class Num implements Comparable<Num>{

        private int num;
        private int mainVal = 0;
        private int size = 1;

        public Num(int n) {
            this.num = n;
            while (n >= 10){
                n /= 10;
                size++;
            }
            mainVal = n;
        }



        @Override
        public int compareTo(Num o) {

            if(mainVal > o.mainVal)
                return -1;
            else if(mainVal < o.mainVal)
                return +1;

            long v0 = (long) (num * Math.pow(10, o.size) + o.num);
            long v1 = (long) (o.num * Math.pow(10, size) + num);

            if(v0 > v1)
                return -1;
            else if(v0 < v1)
                return +1;

            return 0;

        }
    }


}
