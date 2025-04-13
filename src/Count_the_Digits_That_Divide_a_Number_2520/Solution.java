package Count_the_Digits_That_Divide_a_Number_2520;

public class Solution {

    public static void main(String[] args) {

    }


    public static int countDigits(int num) {
        int res = 0;
        int temp = num;
        while (temp > 0) {
            int t = temp % 10;
            temp /= 10;
            if (num % t == 0) res++;

        }
        return res;
    }


}
