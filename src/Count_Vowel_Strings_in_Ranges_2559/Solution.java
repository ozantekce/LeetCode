package Count_Vowel_Strings_in_Ranges_2559;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        System.out.println(Arrays.toString(vowelStrings(new String[]{"aba","bcb","ece","aa","e"},
                new int[][]{{0, 2}, {1, 4}, {1, 1}})));

        System.out.println(Arrays.toString(vowelStrings(new String[]{"a","e","i"},
                new int[][]{{0, 2}, {0, 1}, {2, 2}})));
    }


    public static int[] vowelStrings(String[] words, int[][] queries) {
        int [] result = new int[queries.length];
        int[] prefixSums = new int[words.length+1];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            prefixSums[i+1] = prefixSums[i];
            if(isValid(word)){
                prefixSums[i+1]++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int startIndex = query[0];
            int endIndex = query[1];

            result[i] = prefixSums[endIndex+1] - prefixSums[startIndex];
        }

        return result;
    }


    private static boolean isValid(String word){
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length()-1);

        boolean isFirstVowel = firstChar == 'a' ||
                firstChar == 'e' ||
                firstChar == 'i' ||
                firstChar == 'o' ||
                firstChar == 'u';

        boolean isLastVowel = lastChar == 'a' ||
                lastChar  == 'e' ||
                lastChar  == 'i' ||
                lastChar  == 'o' ||
                lastChar  == 'u';

        return isFirstVowel && isLastVowel;
    }


}
