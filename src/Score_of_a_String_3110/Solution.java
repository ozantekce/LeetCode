package Score_of_a_String_3110;

public class Solution {

    public static void main(String[] args) {

        System.out.println(scoreOfString("hello"));
        System.out.println(scoreOfString("zaz"));

    }


    public static int scoreOfString(String s) {

        int val = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            val += Math.abs(s.charAt(i) - s.charAt(i+1));
        }

        return val;
    }

}
