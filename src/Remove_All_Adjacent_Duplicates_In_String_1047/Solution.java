package Remove_All_Adjacent_Duplicates_In_String_1047;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));

    }

    public static String removeDuplicates(String s) {


        char [] s_chars = s.toCharArray();
        char [] r_chars = new char[s.length()+1];

        r_chars[0] = ' ';
        int end   = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s_chars[i];
            if(end==0){
                end++;
                r_chars[end] = currentChar;
            }else{
                char last = r_chars[end];
                if(last == currentChar){
                    end--;
                }else{
                    end++;
                    r_chars[end] = currentChar;
                }
            }

        }
        //System.out.println(Arrays.toString(r_chars)+" s: "+start+" e: "+end);
        return new String(r_chars,1,end);
    }

}
