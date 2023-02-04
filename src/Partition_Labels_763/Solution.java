package Partition_Labels_763;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));

    }

    public static List<Integer> partitionLabels(String s) {


        char [] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        int start = 0;
        while (true){

            int end = find(chars,start,chars.length-1);
            //System.out.println(end);
            if(end==-1)
                return list;
            int l = end-start+1;
            list.add(l);
            start = end+1;
        }

    }


    public static int find(char[] chars,int start,int end){

        int [] counter = new int[27];
        for (int i = start; i <= end; i++) {
            counter[chars[i]-97]++;
        }

        Set<Integer> checkSet = new HashSet<>();
        for (int i = start; i <= end; i++) {

            checkSet.add((int) chars[i]-97);
            counter[chars[i]-97]--;
            if(counter[chars[i]-97]==0){
                checkSet.remove(chars[i]-97);
            }
            // check
            if(!checkSet.isEmpty()){
                continue;
            }
            return i;
        }
        

        return -1;
    }




}
