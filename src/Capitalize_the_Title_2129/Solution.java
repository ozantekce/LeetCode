package Capitalize_the_Title_2129;

public class Solution {


    public static void main(String[] args) {

        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));

    }


    public static String capitalizeTitle(String title) {

        int start = 0;
        char[] chars = title.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == ' '){
                int length = i - start;
                if(length > 2){
                    if(chars[start]>=97){
                        chars[start] -= 32;
                    }
                }
                start = i + 1;
            }else if(c < 97){
                c += 32;
                chars[i] = c;
            }

        }

        int length = chars.length - start;
        if(length > 2){
            if(chars[start]>=97){
                chars[start] -= 32;
            }
        }


        return new String(chars);
    }


}
