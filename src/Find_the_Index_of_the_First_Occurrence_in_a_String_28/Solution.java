package Find_the_Index_of_the_First_Occurrence_in_a_String_28;

public class Solution {


    public static void main(String[] args) {

        System.out.println(strStr("sadbutsad","sad"));
        System.out.println(strStr("leetcode","leeto"));
        System.out.println(strStr("mississippi","issip"));
        System.out.println(strStr("mississippi","issi"));

    }


    public static int strStr(String haystack, String needle) {

        int state = 0;

        char [] chars = haystack.toCharArray();
        char [] find = needle.toCharArray();


        for (int i = 0; i < chars.length; i++) {

            if(chars[i]==find[state]){
                state++;
                if(state==find.length){
                    return i-find.length+1;
                }
            }else{
                i = i-state;
                state = 0;
            }

        }


        return -1;
    }

}
