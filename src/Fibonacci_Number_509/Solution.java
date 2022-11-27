package Fibonacci_Number_509;

public class Solution {


    public static void main(String[] args) {

        int n = 7;
        System.out.println(fib(n));

    }


    public static int fib(int n) {

        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int a=1,b=1;

        for (int i = 1; i < n-1; i++) {
            int t = b;
            b+=a;
            a=t;
        }

        return b;
    }

}
