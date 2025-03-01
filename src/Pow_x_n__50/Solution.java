package Pow_x_n__50;

public class Solution {


    public static void main(String[] args) {

        System.out.println(myPow(2.0d, 10));
        System.out.println(myPow(2.10000d, 3));
        System.out.println(myPow(2.0d, -2));
        System.out.println(myPow(2.0d, -200000000));
        System.out.println(myPow(2.0d, -2147483648));
        System.out.println(myPow(-3.0d, -5));

    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == 0) return 0;
        long longN = n;
        if (longN < 0) {
            x = 1d / x;
            longN *= -1;
        }
        return find(x, longN);
    }

    public static double find(double x, long n) {
        if (n == 1) return x;
        boolean even = n % 2 == 0;
        double a = find(x, n / 2);
        if (even) {
            return a * a;
        } else {
            return a * a * x;
        }
    }

}
