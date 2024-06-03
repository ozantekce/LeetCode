package Append_Characters_to_String_to_Make_Subsequence_2486;

public class Solution {


    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching","coding"));
        System.out.println(appendCharacters("abcde","a"));
        System.out.println(appendCharacters("z","abcde"));
    }

    public static int appendCharacters(String s, String t) {

        int p_s = 0;
        int p_t = 0;

        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();

        while (p_s < s.length() && p_t < t.length()){
            if(s_chars[p_s] == t_chars[p_t]){
                p_t++;
            }
            p_s++;
        }
        return t.length() - p_t;
    }

}
