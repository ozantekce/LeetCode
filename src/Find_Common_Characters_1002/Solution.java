package Find_Common_Characters_1002;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(commonChars(new String[]{"bella","label","roller"}));
        System.out.println(commonChars(new String[]{"cool","lock","cook"}));

    }



    public static List<String> commonChars(String[] words) {

        int [] resultMap = new int[26];
        String first = words[0];
        for (int i = 0; i < first.length(); i++) {
            resultMap[first.charAt(i)-'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            int [] tempMap = new int[26];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                tempMap[c-'a']++;
            }
            for (int j = 0; j < resultMap.length; j++) {
                if(tempMap[j] == 0 || resultMap[j] == 0){
                    resultMap[j] = 0;
                }
                else{
                    resultMap[j] = Math.min(resultMap[j], tempMap[j]);
                }
            }
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < resultMap.length; i++) {
            for (int j = 0; j < resultMap[i]; j++) {
                result.add(String.valueOf(((char)('a'+i))));
            }
        }


        return result;
    }


}
