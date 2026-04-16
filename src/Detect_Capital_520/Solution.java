package Detect_Capital_520;

public class Solution {

    public static void main(String[] args) {

        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("Flag"));
        System.out.println(detectCapitalUse("flag"));
    }

    public static boolean detectCapitalUse(String word) {

        boolean onlyFirstCapital = true;
        boolean allCapital = true;
        boolean allNotCapital = true;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < 'A' || c > 'Z') {
                allCapital = false;
                break;
            }
        }
        if (allCapital) return true;


        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < 'a' || c > 'z') {
                allNotCapital = false;
                break;
            }
        }
        if (allNotCapital) return true;


        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c < 'a' || c > 'z') {
                    onlyFirstCapital = false;
                    break;
                }
            }
        } else {
            onlyFirstCapital = false;
        }

        if (onlyFirstCapital) return true;

        return false;
    }

}
