package Make_The_String_Great_1544;

import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        System.out.println(makeGood("leEeetcode"));

    }


    public static String makeGood(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (stringBuilder.isEmpty()) {
                stringBuilder.append(c);
            } else {
                char o = stringBuilder.charAt(stringBuilder.length()-1);
                int diff = o - c;
                if (diff == 32 || diff == -32) {
                    stringBuilder.setLength(stringBuilder.length()-1);
                } else {
                    stringBuilder.append(c);
                }
            }

        }

        return stringBuilder.toString();
    }

}
