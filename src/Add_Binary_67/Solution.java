package Add_Binary_67;

import java.util.Arrays;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        String a = "000010100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(addBinary(a,b));

    }

    public static String addBinary(String a, String b) {

        int length = (a.length()>b.length())?a.length():b.length();

        StringBuilder stringBuilder = new StringBuilder();
        boolean carry = false;
        boolean sum;
        boolean first;
        boolean second;
        for (int i = 1; i <= length; i++) {

            first = false;
            second = false;
            if(a.length()-i>=0)
                first = a.charAt(a.length()-i)=='1'?true:false;
            if(b.length()-i>=0)
                second= b.charAt(b.length()-i)=='1'?true:false;

            boolean tempSum = first^second;
            boolean tempCarry = first&second;

            first = tempSum;
            second = carry;
            boolean temSum2 = first^second;
            boolean tempCarry2 = first&second;

            carry = tempCarry2|tempCarry;
            sum = temSum2;

            if(sum)
                stringBuilder.append("1");
            else
                stringBuilder.append("0");

        }
        if(carry){
            stringBuilder.append("1");
        }

        return stringBuilder.reverse().toString();
    }

}
