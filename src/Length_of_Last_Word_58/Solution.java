package Length_of_Last_Word_58;

public class Solution {


    public static void main(String[] args) {

        String s = "   fly me   to   the moon   ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {

        StringBuilder stringBuilder = new StringBuilder(s);

        while (stringBuilder.charAt(stringBuilder.length()-1)==' '){
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        int lastSpace = stringBuilder.lastIndexOf(" ");

        return stringBuilder.length()-lastSpace-1;
    }

    /*
    public static int lengthOfLastWord(String s) {

        String [] strings = s.split(" ");

        return strings[strings.length-1].length();
    }
*/
}
