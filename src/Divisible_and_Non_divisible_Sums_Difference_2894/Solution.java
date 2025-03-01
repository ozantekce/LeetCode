package Divisible_and_Non_divisible_Sums_Difference_2894;

public class Solution {


    public static void main(String[] args) {

        System.out.println(differenceOfSums(10, 3));
    }


    public static int differenceOfSums(int n, int m) {
        int num1 = n * (n + 1) / 2;
        int num2 = 0;
        for (int i = m; i <= n; i += m) {
            num2 += 2 * i;
        }
        return num1 - num2;
    }

}
