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
        recursive(0, s,set, new StringBuilder());
        return Result;
    }

    private static List<String> Result = new ArrayList<>();
    private static void recursive(int i, String s, HashSet<String> set, StringBuilder list){

        if(i == s.length()){
            list.setLength(list.length() - 1);
            Result.add(list.toString());
            list.append(" ");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            String str = stringBuilder.toString();
            if(set.contains(str)){
                list.append(str);
                list.append(" ");
                recursive(i+1, s, set, list);
                list.setLength(list.length() - str.length() - 1);
            }
        }

    }


}
