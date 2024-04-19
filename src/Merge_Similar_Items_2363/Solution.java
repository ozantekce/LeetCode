package Merge_Similar_Items_2363;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        List<List<Integer>> res = mergeSimilarItems(new int[][]{{1,1},{4,5},{3,8}}, new int[][]{{3,1},{1,5}});
        System.out.println(res);
    }


    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        return new ArrayList<>() {
            {
                int[] items = new int[1001];
                int size = 0;
                for (int i = 0; i < items1.length; i++) {
                    items[items1[i][0]] = items1[i][1];
                    size = Math.max(size, items1[i][0]);
                }

                for (int i = 0; i < items2.length; i++) {
                    items[items2[i][0]] += items2[i][1];
                    size = Math.max(size, items2[i][0]);
                }

                for (int i = 0; i <= size; i++) {
                    if(items[i] != 0)
                        this.add(List.of(i, items[i]));
                }

            }
        };
    }

}
