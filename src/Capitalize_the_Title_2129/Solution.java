package Capitalize_the_Title_2129;

public class Solution {


    public static void main(String[] args) {

        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));

    }


    public static String capitalizeTitle(String title) {

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            if(c == ' '){

                char first = sub.charAt(0);
                int start = 0;
                if(sub.length() > 2){
                    if(first>=97){
                        first -= 32;
                        sub.setCharAt(0, first);
                    }
                    start++;
                }


                for (int j = start; j < sub.length(); j++) {
                    char s_c = sub.charAt(j);
                    if(s_c < 97){
                        s_c += 32;
                        sub.setCharAt(j, s_c);
                    }
                }

                stringBuilder.append(sub);
                stringBuilder.append(' ');
                sub.setLength(0);
            }else{
                sub.append(c);
            }

        }

        if(sub.length() != 0){
            char first = sub.charAt(0);
            int start = 0;
            if(sub.length() > 2){
                if(first>=97){
                    first -= 32;
                    sub.setCharAt(0, first);
                }
                start++;
            }

            for (int j = start; j < sub.length(); j++) {
                char s_c = sub.charAt(j);
                if(s_c < 97){
                    s_c += 32;
                    sub.setCharAt(j, s_c);
                }
            }
            stringBuilder.append(sub);
        }

        return stringBuilder.toString();
    }


}
