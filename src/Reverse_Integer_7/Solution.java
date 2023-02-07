package Reverse_Integer_7;

import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        System.out.println(reverse(-1563847412));

    }


    public static int reverse(int x) {

        boolean negative = x<0;

        if(negative)
            x*=-1;

        // find size
        int size = 0;
        int temp = x;
        while (temp>0){
            size++;
            temp/=10;
        }

        long rst = 0;
        while(size>=0){
            int c = x%10;
            rst += c * Math.pow(10,size-1);
            x/=10;
            size--;
            if(rst>Integer.MAX_VALUE)
                return 0;
            if(rst<Integer.MIN_VALUE)
                return 0;
        }
        if(negative)
            rst *=-1;
        return (int) rst;
    }


}
