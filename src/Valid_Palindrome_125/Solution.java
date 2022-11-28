package Valid_Palindrome_125;

public class Solution {

    public static void main(String[] args) {

        System.out.println(isPalindrome("0P"));

    }



    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("((?![a-z0-9]).)*","");
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse();
        //System.out.println(s);
        //System.out.println(s2);
        return s.equals(s2.toString());
    }

}
