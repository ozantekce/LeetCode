package Permutations_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(permute(new int[]{1,2,3}));

    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result,0);
        return result;
    }

    private static void backtracking(int[] nums, List<List<Integer>> result, int size){

        if(size == nums.length){
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i = 0; i < size; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        for (int i = size; i < nums.length; i++) {

            int seq = size;
            int nseq = nums[seq];
            int ni = nums[i];

            nums[i] = nseq;
            nums[seq] = ni;

            size++;
            backtracking(nums,result,size);
            size--;

            nums[seq] = nseq;
            nums[i] = ni;

        }

    }


}
