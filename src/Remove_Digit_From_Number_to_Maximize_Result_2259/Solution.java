package Remove_Digit_From_Number_to_Maximize_Result_2259;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        String number = "73197";
        char digit = '5';
        System.out.println(removeDigit(number,digit));
    }

    public static String removeDigit(String number, char digit) {

        char[] chars = number.toCharArray();
        int last = number.length()-1;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==digit){
                last = i;
                if(i<chars.length-1 &&chars[i]<chars[i+1])
                    return removeCharAt(number,i);
            }
        }
        return removeCharAt(number,last);
    }


    public static String removeCharAt(String str,int val){

        return str.substring(0,val)+str.substring(val+1,str.length());
    }

}
