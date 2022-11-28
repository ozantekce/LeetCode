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
        long rst = 0;
        Stack<Integer> stack = new Stack<>();
        while(x>0){
            stack.push(x%10);
            x/=10;
        }
        int m =stack.size()-1;
        for(int val : stack){
            rst += val*Math.pow(10,m);
            m--;
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
