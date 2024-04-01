package Permutations_46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(permute(new int[]{1,2,3}));

    }


    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>(nums.length), new HashSet<>(nums.length));
        return result;
    }

    private static void backtracking(int[] nums, List<List<Integer>> result, List<Integer> current, HashSet<Integer> skip){

        if(skip.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!skip.contains(i)){
                current.add(nums[i]);
                skip.add(i);
                backtracking(nums,result,current,skip);
                current.remove((Object)nums[i]);
                skip.remove(i);
            }
        }

    }


}
