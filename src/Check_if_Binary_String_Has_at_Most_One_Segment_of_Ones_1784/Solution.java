package Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones_1784;

public class Solution {


    public static void main(String[] args) {

        System.out.println(checkOnesSegment("1001"));
        System.out.println(checkOnesSegment("110"));
        System.out.println(checkOnesSegment("1"));
        System.out.println(checkOnesSegment("10"));

    }


    public static boolean checkOnesSegment(String s) {


        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '1'){
                index = i;
                break;
            }
        }

        if(index == 0)
            return true;

        for (int i = index+1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '1')
                return false;
        }

        return true;
    }

}
