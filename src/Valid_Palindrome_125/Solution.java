package Valid_Palindrome_125;

public class Solution {

    public static void main(String[] args) {

        System.out.println(isPalindrome("0P"));
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome("race a car"));
        //System.out.println(isPalindrome(" "));

    }



    public static boolean isPalindrome(String s) {

        // create valid string
        StringBuilder validString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c>=97&&c<=122) || (c>=48&&c<=57)){
                validString.append(c);
            }else if(c>=65&&c<=90){
                c+=32;
                validString.append(c);
            }
        }
        System.out.println(validString);
        //check
        boolean isPalindrome = true;
        int first = 0, last = validString.length() - 1;
        while (first < last) {
            if (validString.charAt(first) != validString.charAt(last)) {
                isPalindrome =  false;
                break;
            }
            first++;
            last--;
        }
        return isPalindrome;
    }




}
