package Largest_3_Same_Digit_Number_in_String_2264;

public class Solution {


    public static void main(String[] args) {

    }


    public static String largestGoodInteger(String num) {
        int size = 1;
        char max = 0;
        char l = num.charAt(0);
        for (int i = 1; i < num.length(); i++) {
            char c = num.charAt(i);
            if(l == c){
                size++;
                if(size == 3){
                    if(c > max){
                        max = c;
                    }
                }
            }else{
                size = 1;
                l = c;
            }
        }

        if(max == 0)
            return "";
        else{
            return new String(new char[]{max, max, max});
        }
    }

}
