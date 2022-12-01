package Break_a_Palindrome_1328;

public class Solution {


    public static void main(String[] args) {


        System.out.println(breakPalindrome("a"));

    }



    public static String breakPalindrome(String palindrome) {
        char [] chars = palindrome.toCharArray();

        if(chars.length%2==0){
            for (int i = 0; i < chars.length; i++) {
                if(chars[i]!='a'){
                    chars[i] = 'a';
                    return new String(chars);
                }
            }
            // All A
            chars[chars.length-1] = 'b';
            return new String(chars);
        }else{

            int mid = (chars.length+0)/2;
            boolean midA = chars[mid] == 'a';

            for (int i = 0; i < chars.length; i++) {
                if(i==mid)
                    continue;
                if(chars[i]!='a'){
                    chars[i] = 'a';
                    return new String(chars);
                }
            }
            if(chars.length==3){
                chars[2]='b';
                return new String(chars);
            }else if(chars.length>3){
                chars[chars.length-1] = 'b';
                return new String(chars);
            }else{
                return "";
            }

        }


    }

}
