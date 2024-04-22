package Largest_3_Same_Digit_Number_in_String_2264;

public class Solution {


    public static void main(String[] args) {

    }


    public static String largestGoodInteger(String num) {

        String [] strings = new String[]{"999","888","777","666","555","444","333","222","111","000"};
        for (String str : strings) {
            if (num.contains(str)) {
                return str;
            }
        }
        return "";
    }


}
