package Word_Break_II_140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {



    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
    }


    public static List<String> wordBreak(String s, List<String> wordDict) {
        Result.clear();
        HashSet<String> set = new HashSet<>(wordDict);
        recursive(0, s, set, new StringBuilder());
        return Result;
    }

    private static List<String> Result = new ArrayList<>();
    private static void recursive(int i, String s, HashSet<String> set, StringBuilder current){

        int startFrom = i;
        for (; i < s.length(); i++) {
            String str = s.substring(startFrom, i+1);
            if(set.contains(str)){
                current.append(str);
                if(i+1 == s.length()){
                    Result.add(current.toString());
                    current.setLength(current.length() - str.length());
                    break;
                }
                current.append(" ");
                recursive(i+1, s, set, current);
                current.setLength(current.length() - str.length() - 1);
            }
        }
    }


}
