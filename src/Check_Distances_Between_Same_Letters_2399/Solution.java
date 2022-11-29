package Check_Distances_Between_Same_Letters_2399;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {


        String s = "abaccb";
        int [] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        System.out.println(checkDistances(s,distance));


    }


    public static boolean checkDistances(String s, int[] distance) {


        char [] chars = s.toCharArray();
        int  [] first = new int[26];
        for (int i = 0; i < first.length; i++) {
            first[i]=-1;
        }
        for (int i = 0; i < s.length(); i++) {

            if(first[chars[i]-97]==-1){
                first[chars[i]-97] = i;
            }else{
                int dst = i-first[chars[i]-97]-1;
                if(distance[chars[i]-97]!=dst){
                    return false;
                }
            }

        }

        return true;
    }

}
