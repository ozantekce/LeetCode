package Isomorphic_Strings_205;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba","aaabbbba"));
    }


    public static boolean isIsomorphic(String s, String t) {

        if(s.length()!=t.length())
            return false;

        HashMap<Character,Character> hashMap1 = new HashMap<>();
        HashMap<Character,Character> hashMap2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);

            boolean control1 = false,control2 =false;
            boolean c1=false,c2=false;
            if(hashMap1.containsKey(first)){
                c1 = hashMap1.get(first) == second;
                control1 = true;
            }
            if(hashMap2.containsKey(second)){
                c2 = hashMap2.get(second) == first;
                control2 = true;
            }

            if(control1!=control2)
                return false;
            if(control1==true){
                if((c1&&c2)==false)
                    return false;
            }else{
                hashMap1.put(first,second);
                hashMap2.put(second,first);
            }

        }

        return true;
    }


}
