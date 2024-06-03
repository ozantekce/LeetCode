package Append_Characters_to_String_to_Make_Subsequence_2486;

public class Solution {


    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching","coding"));
        System.out.println(appendCharacters("abcde","a"));
        System.out.println(appendCharacters("z","abcde"));
    }

    public static int appendCharacters(String s, String t) {
        int p = 0;
        for (int i = 0; i < s.length() && p < t.length(); i++) {
            if(s.charAt(i) == t.charAt(p)){
                p++;
            }
        }
        return t.length() - p;
    }


}
