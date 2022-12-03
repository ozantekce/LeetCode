package Rotate_String_796;

public class Solution {




    public static void main(String[] args) {


        System.out.println(rotateString("abcde","abced"));

    }



    public static boolean rotateString(String s, String goal) {

        if(s.length()!=goal.length())
            return false;
        char [] sourceChars = s.toCharArray();
        char [] goalChars = goal.toCharArray();

        for (int i = 0; i < sourceChars.length; i++) {
            int handler = i;
            boolean control = true;
            for (int j = 0; j < sourceChars.length; j++) {
                if(sourceChars[j] != goalChars[(j+handler)%sourceChars.length]){
                    control = false;
                    break;
                }
            }
            if(control){
                return true;
            }
            
        }

        return false;
    }


}
