package Separate_Black_and_White_Balls_2938;

public class Solution {

    public static void main(String[] args) {

        System.out.println(minimumSteps("101"));
        System.out.println(minimumSteps("100"));
        System.out.println(minimumSteps("0111"));

    }


    public static long minimumSteps(String s) {
        long result = 0;
        int targetIndex = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '0'){
                result += (i-targetIndex);
                targetIndex++;
            }
        }
        
        return result;
    }

}
