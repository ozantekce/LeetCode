package Remove_All_Occurrences_of_a_Substring_1910;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrences("a", "aa"));
        //System.out.println(removeOccurrences("axxxxyyyyb", "xy"));
        //System.out.println(removeOccurrences("ccctltctlltlb", "ctl"));
        System.out.println(removeOccurrences("kpygkivtlqoockpygkivtlqoocssnextkqzjpycbylkaondsskpygkpygkivtlqoocssnextkqzjpkpygkivtlqoocssnextkqzjpycbylkaondsycbylkaondskivtlqoocssnextkqzjpycbylkaondssnextkqzjpycbylkaondshijzgaovndkjiiuwjtcpdpbkrfsi", "kpygkivtlqoocssnextkqzjpycbylkaonds"));
    }


    public static String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();
        if (m > n) return s;

        int[] lps = calculateLps(part);
        int sizeOfRes = 0;
        int sizeOfPointers = 1;
        char[] res = new char[n];
        int[] pointers = new int[n+1];

        int i = 0;
        int j = 0;
        while (i < n) {
            if (s.charAt(i) == part.charAt(j)) {
                res[sizeOfRes++] = s.charAt(i);
                i++;
                j++;
                pointers[sizeOfPointers++] = j;
                if (j == m) {
                    sizeOfRes -= m;
                    sizeOfPointers -= m;
                    j = pointers[sizeOfPointers - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    res[sizeOfRes++] = s.charAt(i);
                    pointers[sizeOfPointers++] = j;
                    i++;
                }
            }
        }

        return new String(res, 0, sizeOfRes);
    }


    private static int[] calculateLps(String part) {
        int[] lps = new int[part.length()];
        int p = 0;
        lps[0] = 0;
        int i = 1;
        while (i < part.length()) {
            if (part.charAt(i) == part.charAt(p)) {
                p++;
                lps[i] = p;
                i++;
            } else {
                if (p != 0) {
                    p = lps[p - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}
