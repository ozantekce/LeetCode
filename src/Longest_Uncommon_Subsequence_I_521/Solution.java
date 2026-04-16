package Longest_Uncommon_Subsequence_I_521;

public class Solution {

    public static void main(String[] args) {

    }

    public static int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        else return Math.max(a.length(), b.length());
    }

}
