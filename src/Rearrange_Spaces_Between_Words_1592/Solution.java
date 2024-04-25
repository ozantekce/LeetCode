package Rearrange_Spaces_Between_Words_1592;
import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(reorderSpaces("  this   is  a sentence "));
        System.out.println(reorderSpaces(" practice   makes   perfect"));
        System.out.println(reorderSpaces("a"));
        System.out.println(reorderSpaces("  hello"));

    }


    public static String reorderSpaces(String text) {

        int spaces = 0;
        List<Integer> list = new ArrayList<>();
        char l = ' ';
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c == ' '){
                spaces++;
            }else if(l == ' '){
                list.add(i);
            }
            l = c;
        }

        if(spaces == 0){
            return text;
        }

        int words = list.size();
        int addSpaces = 0;

        if(words > 1){
            addSpaces = spaces / (words-1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.get(i); j < text.length(); j++) {
                char c = text.charAt(j);
                if(c == ' '){
                    break;
                }
                stringBuilder.append(c);
            }
            if(i != list.size()-1){
                for (int j = 0; j < addSpaces; j++) {
                    stringBuilder.append(' ');
                    spaces--;
                }
            }

        }
        stringBuilder.append(" ".repeat(Math.max(0, spaces)));

        return stringBuilder.toString();
    }

}
