package Longest_Substring_Without_Repeating_Characters_3;

import java.util.Arrays;


public class Solution {


    public static void main(String[] args) {

        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //System.out.println(lengthOfLongestSubstring("abba"));
        //System.out.println(lengthOfLongestSubstring("bbbbb"));
        //System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));

    }

    public static int lengthOfLongestSubstring(String s) {

        int maxSize = 1;
        char [] chars = s.toCharArray();
        if(chars.length == 0)
            return 0;
        int size = 0;
        int [] set = new int[96];
        Arrays.fill(set, -1);
        for (int i = 0; i < chars.length; i++) {
            byte c = (byte) (chars[i] - ' ');
            if(set[c] == -1){
                set[c] = i;
            }else{
                maxSize = Math.max(maxSize, size);
                int j = set[c];
                size = 0;
                for (int k = 0; k < 96; k++) {
                    if(set[k] < j){
                        set[k] = -1;
                    }else if(set[k] > j){
                        size++;
                    }
                }
                set[c] = i;
            }
            size++;
            //System.out.println(chars[i] +" "+size+" "+maxSize);
        }

        maxSize = Math.max(maxSize, size);
        return maxSize;
    }

}
