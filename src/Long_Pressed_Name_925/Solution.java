package Long_Pressed_Name_925;

public class Solution {


    public static void main(String[] args) {

        System.out.println(isLongPressedName("alex","aaleex"));
        System.out.println(isLongPressedName("saeed","ssaaedd"));
        System.out.println(isLongPressedName("leelee","lleeelee"));
        System.out.println(isLongPressedName("alex","aaleexa"));

    }

    public static boolean isLongPressedName(String name, String typed) {


        char[] chars_name  = name.toCharArray();
        char[] chars_typed = typed.toCharArray();

        int typed_index = 0;
        for (int i = 0; i < chars_name.length; i++) {
            char current_c = chars_name[i];
            int count1 = 1;
            int j;
            for ( j = i+1; j < chars_name.length; j++) {
                if(chars_name[j]==current_c)count1++;
                else break;
            }
            i=j-1;
            int count2 = 0;
            for (; typed_index < chars_typed.length; typed_index++) {
                if(chars_typed[typed_index]==current_c)count2++;
                else break;
            }
            if(count2<count1){
                return false;
            }

        }


        return typed_index==typed.length();
    }

}
