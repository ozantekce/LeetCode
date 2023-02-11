package Most_Common_Word_819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {


        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c",
                new String[]{"a"}));

    }


    public static String mostCommonWord(String paragraph, String[] banned) {

        HashMap<String,Integer> counter = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i]);
        }

        char [] chars = paragraph.toCharArray();
        StringBuilder current = new StringBuilder();
        int max = 0;
        String rst = "";
        String str;
        for (int i = 0; i < chars.length; i++) {

            char c = chars[i];
            //space or ignore
            if(c>=32&&c<=63){
                str = current.toString();
                if(bannedSet.contains(str) || str.equals("")){
                    current.setLength(0);
                    continue;
                }
                int value = counter.getOrDefault(str,0)+1;
                if(value>max){
                    max = value;
                    rst = str;
                }
                counter.put(str,value);
                current.setLength(0);
                continue;
            }
            //Uppercase
            if(c>=65 && c<=90){
                // to lower
                c += 32;
            }
            current.append(c);
        }

        str = current.toString();
        if(bannedSet.contains(str)){
            current.setLength(0);
        }
        int value = counter.getOrDefault(str,0)+1;
        if(value>max){
            rst = str;
        }
        counter.put(str,value);

        //System.out.println(counter);

        return rst;
    }

}
