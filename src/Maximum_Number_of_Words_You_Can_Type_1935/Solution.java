package Maximum_Number_of_Words_You_Can_Type_1935;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {


        System.out.println(canBeTypedWords("hello world","ad"));
        System.out.println(canBeTypedWords("leet code","lt"));
        System.out.println(canBeTypedWords("leet code","e"));

    }

    public static int canBeTypedWords(String text, String brokenLetters) {

        int score = 0;
        boolean moveAnotherWord = false;

        boolean [] brokens = new boolean[26];
        char [] brokenChars = brokenLetters.toCharArray();

        for (int i = 0; i < brokenChars.length; i++) brokens[brokenChars[i]-97] = true;

        char [] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            char current = chars[i];
            boolean isSpace = current == ' ';
            if(moveAnotherWord && !isSpace)continue;

            if(moveAnotherWord){
                moveAnotherWord = false;
            }
            else if(!isSpace &&brokens[current-97]){
                moveAnotherWord = true;
            }else if(isSpace){
                score++;
            }

        }

        if(!moveAnotherWord) score++;

        return score;
    }

}
