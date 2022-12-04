package Valid_Perfect_Square_367;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(isPerfectSquare(2000105819));

    }

    public static boolean isPerfectSquare(int num) {

        if(num==1||num==4)
            return true;

        long min = 2;
        long max = num/2;
        while (min<max){

            long mid = (min+max)/2;
            if(mid*mid<num){
                min = mid+1;
            }else if(mid*mid>num){
                max = mid;
            }else{
                return true;
            }

        }

        return false;
    }


    public static List<Integer> primeFactors(int n)
    {
        List<Integer> primes = new ArrayList<>();
        while (n % 2 == 0) {
            primes.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primes.add(i);
                n /= i;
            }
        }
        if (n > 2)
            primes.add(n);
        return primes;
    }


}
