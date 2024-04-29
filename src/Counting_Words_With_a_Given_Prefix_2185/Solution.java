package Counting_Words_With_a_Given_Prefix_2185;

public class Solution {


    public static void main(String[] args) {

    }


    public static int prefixCount(String[] words, String pref) {

        int res = 0;
        for (String str : words) {
            if(str.startsWith(pref))
                res++;
        }
        return res;
    }

}
