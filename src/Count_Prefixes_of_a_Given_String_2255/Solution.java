package Count_Prefixes_of_a_Given_String_2255;

public class Solution {


    public static int countPrefixes(String[] words, String s) {

        char[] chars = s.toCharArray();
        char[][] charsOfWords = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            charsOfWords[i] = words[i].toCharArray();
        }

        int counter = 0;
        UpFor:
        for (int i = 0; i < charsOfWords.length; i++) {

            if(charsOfWords[i].length>=chars.length){
                continue ;
            }
            for (int j = 0; j < charsOfWords[i].length; j++) {
                if(charsOfWords[i][j] != chars[j]){
                    continue UpFor;
                }
            }
            counter++;
        }


        return counter;
    }

}
