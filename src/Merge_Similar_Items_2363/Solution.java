package Merge_Similar_Items_2363;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

    }


    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        TreeMap<Integer, int []> map = new TreeMap<>();

        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], items1[i]);
        }

        for (int i = 0; i < items2.length; i++) {

            if(map.containsKey(items2[i][0])){
                int [] array = map.get(items2[i][0]);
                array[1] += items2[i][1];
            }else{
                map.put(items2[i][0], items2[i]);
            }
            
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int[] v : map.values()) {
            res.add(Arrays.asList(v[0],v[1]));
        }


        return res;
    }

}
