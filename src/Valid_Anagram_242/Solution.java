package Valid_Anagram_242;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(isAnagram("rat","cat"));

    }

    public static boolean isAnagram(String s, String t) {

        if(t.length()!=s.length())
            return false;

        int [] counter = new int[26]; // 97 - 123

        char [] sChars = s.toCharArray();
        char [] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            counter[sChars[i]-97]++;
            counter[tChars[i]-97]--;
        }

        for (int i = 0; i < counter.length; i++) {
            if(counter[i]!=0)
                return false;
        }


        return true;
    }

}
