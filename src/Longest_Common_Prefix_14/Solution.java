package Longest_Common_Prefix_14;

public class Solution {

    public static void main(String[] args) {

        String[] strs = {"ab","a"};
        System.out.println(longestCommonPrefix(strs));

    }


    public static String longestCommonPrefix(String[] strs) {

        String first = strs[0];
        if(first.equals(""))
            return "";
        int i=0;
        upperFor:
        for (; i < first.length(); i++) {
            char currentChar = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length()<=i||strs[j].equals("")||strs[j].charAt(i)!=currentChar){
                    break upperFor;
                }
            }
        }

        return first.substring(0,i);
    }


}
