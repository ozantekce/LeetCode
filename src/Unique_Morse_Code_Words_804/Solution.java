package Unique_Morse_Code_Words_804;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {

        System.out.println(uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));

    }

    private static String []array = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public static int uniqueMorseRepresentations(String[] words) {

        Set<String> set = new HashSet<>();

        StringBuilder current = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                current.append(array[words[i].charAt(j)-97]);
            }
            set.add(current.toString());
            current.setLength(0);
        }

        return set.size();
    }

}
