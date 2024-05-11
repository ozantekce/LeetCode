package Merge_Strings_Alternately_1768;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));

    }


    public static String mergeAlternately(String word1, String word2) {

        char [] res = new char[word1.length() + word2.length()];
        int p1 = 0;
        int p2 = 0;

        String longOne;
        if(word1.length() > word2.length()){
            longOne = word1;
        }else{
            longOne = word2;
        }
        int size = Math.min(word1.length(), word2.length());
        int j = 0;
        while (p1 < size) {
            res[j++] = word1.charAt(p1++);
            res[j++] = word2.charAt(p2++);
        }
        for (int i = p1; i < longOne.length(); i++) {
            res[j++] = longOne.charAt(i);
        }

        return new String(res);
    }


}
