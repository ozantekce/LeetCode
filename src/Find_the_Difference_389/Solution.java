package Find_the_Difference_389;

public class Solution {

    public static void main(String[] args) {


        System.out.println(findTheDifference("abcd","abcde"));

    }



    public static char findTheDifference(String s, String t) {

        char [] sChars = s.toCharArray();
        char [] tChars = t.toCharArray();

        int value = tChars[tChars.length-1];
        for (int i = 0; i < sChars.length; i++) {
            value^=sChars[i]^tChars[i];
        }

        return (char) value;
    }


}
