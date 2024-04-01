package Permutations_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(permute(new int[]{1,2,3}));

    }


    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new MyList(nums.length));
        return result;
    }

    private static void backtracking(int[] nums, List<List<Integer>> result, MyList current){

        if(current.size() == nums.length){
            result.add(current.getAsList());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(current.contains(nums[i]))
                continue;
            current.add(nums[i]);
            backtracking(nums,result,current);
            current.removeLast();
        }

    }

    private static class MyList{
        private boolean set [];
        private int nums [];
        private int size;

        public MyList(int capacity){
            nums = new int[capacity];
            size = 0;
            set = new boolean[22];
        }

        public void add(int num){
            nums[size++] = num;
            set[num+10] = true;
        }
        public void removeLast(){
            set[nums[size-1]+10] = false;
            size--;
        }

        public List<Integer> getAsList() {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(nums[i]);
            }
            return list;
        }

        public int size(){
            return size;
        }

        public boolean contains(int num){
            return set[num+10];
        }

    }


}
