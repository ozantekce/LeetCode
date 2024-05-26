package Word_Break_139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet","code"))));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Memory = new boolean[s.length()];
        return recursive(0, s, set);
    }

    private static boolean [] Memory;
    private static boolean recursive(int i, String s, HashSet<String> set){
        int startFrom = i;
        if(Memory[startFrom]){
            return false;
        }
        for (; i < s.length(); i++) {
            String str = s.substring(startFrom, i+1);
            if(set.contains(str)){
                if(i+1 == s.length()){
                    return true;
                }
                if(recursive(i+1, s, set)){
                    return true;
                }

            }
        }
        Memory[startFrom] = true;
        return false;
    }

}
