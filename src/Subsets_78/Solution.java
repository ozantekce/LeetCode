package Subsets_78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {


        int nums [] = {1,2,3};
        System.out.println(subsets(nums));

    }



    public static List<List<Integer>> subsets(int[] nums) {

        allLists.clear();
        find(-1,nums,new ArrayList<>());

        return allLists;
    }

    private static List<List<Integer>> allLists = new ArrayList<>();

    public static void find(int index ,int [] nums,List<Integer> list){
        List<Integer> nextList;
        if(index!=-1){
            nextList = new ArrayList<>(list);
            nextList.add(nums[index]);
        }else{
            nextList = list;
        }
        for (int i = index+1; i < nums.length; i++) {
            find(i,nums,nextList);
        }
        allLists.add(nextList);
    }


}
