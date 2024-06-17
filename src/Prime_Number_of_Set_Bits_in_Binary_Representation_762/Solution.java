package Prime_Number_of_Set_Bits_in_Binary_Representation_762;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countPrimeSetBits(6, 10));
    }


    public static int countPrimeSetBits(int left, int right) {

        int res = 0;
        for (int i = left; i <= right; i++) {
            if(control(i))
                res++;
        }
        return res;
    }


    private static boolean control(int num){
        int oneCount = hammingWeight(num);
        return isPrime(oneCount);
    }


    public static int hammingWeight(int n) {
        int res = 0;
        while (1 <= n){
            if((n & 1) != 0)
                res++;
            n >>= 1;
        }
        return res;
    }


    private static boolean isPrime(int n){
        if (n <= 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

}
