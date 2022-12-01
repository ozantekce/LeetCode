package Word_Pattern_290;

import java.util.HashMap;
import java.util.Objects;

public class Solution {

    public static void main(String[] args) {

        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog dog dog dog"));

    }


    public static boolean wordPattern(String pattern, String s) {

        String[] values = s.split(" ");
        char [] keys = pattern.toCharArray();

        if(keys.length!=values.length)
            return false;

        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> mapInverse = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            if(map.containsKey(keys[i]) && mapInverse.containsKey(values[i])){
                if(!Objects.equals(values[i], map.get(keys[i]))){
                    return false;
                }
            }else if(!map.containsKey(keys[i]) && !mapInverse.containsKey(values[i])){
                map.put(keys[i],values[i]);
                mapInverse.put(values[i],keys[i]);
            }else {
                return false;
            }
        }

        return true;
    }


}
