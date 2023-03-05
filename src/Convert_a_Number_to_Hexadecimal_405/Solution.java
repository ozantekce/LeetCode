package Convert_a_Number_to_Hexadecimal_405;

import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        System.out.println(toHex(26));
        System.out.println(toHex(-256));
        System.out.println(toHex(-2147483648));
    }

    public static String toHex(int num) {

        if(num==0)
            return "0";

        char [] numbers = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        StringBuilder stringBuilder = new StringBuilder();

        int rec = num;
        boolean isNeg = num<0;
        boolean addOne = false;
        if(num<0)num+=268435456;
        if(num<0){
            isNeg = false;
            addOne = true;
            num = (rec+1)*-1;
        }

        while (num>0){
            int c = num%16;
            num/=16;
            if(addOne){
                if(numbers[c]=='f'){
                    stringBuilder.append('0');
                }else{
                    stringBuilder.append(numbers[c+1]);
                }
            }else{
                stringBuilder.append(numbers[c]);
            }


        }
        if(isNeg)stringBuilder.append('f');


        return stringBuilder.reverse().toString();


    }

}
