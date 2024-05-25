package Maximum_Score_Words_Formed_by_Letters_1255;

public class Solution {


    public static void main(String[] args) {

    }


    public static int maxScoreWords(String[] words, char[] letters, int[] score) {

        int [] counts = new int[26];
        for (int i = 0; i < letters.length; i++) {
            counts[letters[i] - 'a']++;
        }
        return recursive(0, words, score, counts);
    }
    
    private static int recursive(int i, String[] words, int[] score, int[] counts){
        int val = 0;
        for (; i < words.length; i++) {

            String word = words[i];
            int [] counter = new int[26];
            for (int j = 0; j < word.length(); j++) {
                int c = word.charAt(j) - 'a';
                counter[c]++;
            }
            boolean isValid = true;
            for (int j = 0; j < 26; j++) {
                if(counter[j] > counts[j]){
                    isValid = false;
                    break;
                }
            }
            int scr = 0;
            if(isValid){
                for (int j = 0; j < 26; j++) {
                    counts[j] -= counter[j];
                    scr += score[j] * counter[j];
                }
                scr += recursive(i+1, words, score, counts);
                for (int j = 0; j < 26; j++) {
                    counts[j] += counter[j];
                }

            }

            val = Math.max(val, scr);
        }
        
        return val;
    }

}
