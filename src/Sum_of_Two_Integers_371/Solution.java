package Sum_of_Two_Integers_371;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getSum(20, 30));
    }

    public static int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = ((a & b) << 1);
        if (carry == 0) return sum;
        else return getSum(sum, carry);
    }


}
