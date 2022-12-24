package Check_if_Number_Has_Equal_Digit_Count_and_Digit_Value_2283;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
    }
    
    
    public static boolean digitCount(String num) {
        
        char [] chars = num.toCharArray();
        
        int [] counter = new int[10];

        for (int i = 0; i < num.length(); i++) {
            counter[chars[i]-48]++;
        }

        for (int i = 0; i < num.length(); i++) {
            if(chars[i]-48 != counter[i])
                return false;
        }
        
        
        return true;
    }


}
