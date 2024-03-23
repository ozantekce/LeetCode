package Make_Number_of_Distinct_Characters_Equal_2531;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(isItPossible("ac","b"));
        //System.out.println(isItPossible("abcc","aab"));
        //System.out.println(isItPossible("abcde","fghij"));
        //System.out.println(isItPossible("ab","abcc"));
        //System.out.println(isItPossible("a","bb"));
        //System.out.println(isItPossible("aa","ab"));
        System.out.println(isItPossible("wilfuzpxqserkdcvbgajtyhon","rlmyvwvucqxsjodbelmgjkabnxegihuwats"));

    }



    public static boolean isItPossible(String word1, String word2) {

        int[] counter1 = new int[26];
        int[] counter2 = new int[26];

        int distinct1 = 0;
        int distinct2 = 0;

        for (int i = 0; i < word1.length(); i++) {
            int index = word1.charAt(i) - 97;
            if(counter1[index] == 0) distinct1++;
            counter1[index]++;
        }
        for (int i = 0; i < word2.length(); i++) {
            int index = word2.charAt(i) - 97;
            if(counter2[index] == 0) distinct2++;
            counter2[index]++;
        }

        if(distinct1 - distinct2 > 2 || distinct2 - distinct1 > 2) return false;

        for (int i = 0; i < 26; i++) {
            if (counter1[i] == 0) continue;
            for (int j = 0; j < 26; j++) {
                if (counter2[j] == 0) continue;

                if(i == j){
                    if(distinct1 == distinct2) return true;
                    else continue;
                }

                // swap
                int distinct1_new = distinct1;
                int distinct2_new = distinct2;

                if(counter1[i] == 1) distinct1_new--;
                if(counter1[j] == 0) distinct1_new++;

                if(counter2[i] == 0) distinct2_new++;
                if(counter2[j] == 1) distinct2_new--;

                if(distinct1_new == distinct2_new) return true;
            }

        }


        return false;
    }



}
