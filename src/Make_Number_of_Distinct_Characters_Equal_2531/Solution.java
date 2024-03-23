package Make_Number_of_Distinct_Characters_Equal_2531;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(isItPossible("ac","b"));
        //System.out.println(isItPossible("abcc","aab"));
        //System.out.println(isItPossible("abcde","fghij"));
        //System.out.println(isItPossible("ab","abcc"));
        //System.out.println(isItPossible("a","bb"));
        System.out.println(isItPossible("aa","ab"));
        //System.out.println(isItPossible("wilfuzpxqserkdcvbgajtyhon","rlmyvwvucqxsjodbelmgjkabnxegihuwats"));

    }



    public static boolean isItPossible(String word1, String word2) {

        int[] counter1 = new int[26];
        int[] counter2 = new int[26];

        int distinct1 = 0;
        int distinct2 = 0;

        for (int i = 0; i < word1.length(); i++) {
            int index = word1.charAt(i)- 'a';
            if(counter1[index] == 0)
                distinct1++;
            counter1[index]++;
        }
        for (int i = 0; i < word2.length(); i++) {
            int index = word2.charAt(i)- 'a';
            if(counter2[index] == 0)
                distinct2++;
            counter2[index]++;
        }

        if(distinct1 - distinct2 > 2 || distinct2 - distinct1 > 2) return false;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {

                //if(i == j) continue;

                int charCount_I_1 = counter1[i];
                int charCount_J_1 = counter1[j];
                if (charCount_I_1 == 0) break;

                int charCount_I_2 = counter2[i];
                int charCount_J_2 = counter2[j];
                if (charCount_J_2 == 0) continue;

                if(i == j){
                    if(distinct1 == distinct2) return true;
                    else continue;
                }

                // swap
                charCount_I_1--;
                charCount_J_1++;

                charCount_I_2++;
                charCount_J_2--;

                int distinct1_new = distinct1;
                int distinct2_new = distinct2;

                if(charCount_I_1 == 0) distinct1_new--;
                if(charCount_J_1 == 1) distinct1_new++;
                if(charCount_J_2 == 0) distinct2_new--;
                if(charCount_I_2 == 1) distinct2_new++;

                if(distinct1_new == distinct2_new) return true;
            }

        }


        return false;
    }



}
