package Count_Good_Numbers_1922;

public class Solution {


    public static void main(String[] args) {

    }


    public static int countGoodNumbers(long n) {
        int evenDigitCount = 5;
        int primeDigitCount = 4;

        if (n % 2 == 0) {
            return mul(pow(evenDigitCount, n / 2), pow(primeDigitCount, n / 2));
        } else {
            return mul(pow(evenDigitCount, (n + 1) / 2), pow(primeDigitCount, n / 2));
        }
    }


    private static int mul(int a, int b) {
        long m = 1000000007;
        return (int) ((long) a * b % m);
    }

    private static int pow(int a, long b) {
        long m = 1000000007L;
        long result = 1;
        long base = a % m;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * base) % m;
            }
            base = (base * base) % m;
            b >>= 1;
        }

        return (int) result;
    }


}
