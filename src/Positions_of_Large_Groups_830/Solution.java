package Positions_of_Large_Groups_830;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {

        System.out.println(largeGroupPositions("abbxxxxzzy"));
        System.out.println(largeGroupPositions("abc"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcdddd"));

    }

    public static List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> results = new ArrayList<>();
        int size = 0;
        char [] chars = s.toCharArray();
        char l_c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char c_c = chars[i];
            if(c_c == l_c){
                size++;
            }else{
                if(size>=2){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i-size-1);
                    temp.add(i-1);
                    results.add(temp);
                }
                size = 0;
            }
            l_c = c_c;
        }

        if(size>=2){
            List<Integer> temp = new ArrayList<>();
            temp.add(s.length()-size-1);
            temp.add(s.length()-1);
            results.add(temp);
        }

        return results;
    }




}
