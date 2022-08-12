package Find_First_Palindromic_String_in_the_Array_2108;

public class Solution {


    public static void main(String[] args) {

        String[] words = {"abc","car","ada","racecar","cool"};

        System.out.println(firstPalindrome(words));

    }

    public static String firstPalindrome(String[] words) {

        for (int i = 0; i < words.length; i++) {
            if(isPalindrome(words[i])){
                return words[i];
            }
        }

        return "";
    }



    public static boolean isPalindrome(String x) {

        char [] val = x.toCharArray();

        int first=0,last=val.length-1;
        while (true){

            if(first>=last){
                break;
            }
            if(val[first]!= val[last]){
                return false;
            }

            first++;
            last--;

        }
        return true;
    }

}
