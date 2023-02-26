package Is_Subsequence_392;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {


        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("axc","ahbgdc"));
        System.out.println(isSubsequence("acb","ahbgdc"));
        System.out.println(isSubsequence("","ahbgdc"));

    }

    public static boolean isSubsequence(String s, String t) {
        if(s.equals(""))
            return true;

        char [] sChars = s.toCharArray();
        int pointer = 0;
        char [] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            if(tChars[i]==sChars[pointer]){
                pointer++;
                if(pointer == sChars.length)return true;
            }
        }
        return false;
    }

}
