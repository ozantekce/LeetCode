package Mirror_Distance_of_an_Integer_3783;

public class Solution {

    public static void main(String[] args) {

    }

    public static int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    public static int reverse(int value) {
        int res = 0;
        while (value > 0) {
            res *= 10;
            int d = value % 10;
            res += d;
            value /= 10;
        }
        return res;
    }

}
