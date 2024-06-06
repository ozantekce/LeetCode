package Divide_Array_in_Sets_of_K_Consecutive_Numbers_1296;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }


    public boolean isPossibleDivide(int[] nums, int k) {

        if(nums.length % k != 0){
            return false;
        }

        Arrays.sort(nums);

        HashMap<Integer,Integer> counter = new HashMap<>();
        List<Integer> sortedSet = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(counter.containsKey(nums[i])){
                counter.put(nums[i], counter.get(nums[i])+1);
            }else{
                counter.put(nums[i], 1);
                sortedSet.add(nums[i]);
            }
        }

        for (int i = 0; i < sortedSet.size();) {
            int firstValue = sortedSet.get(i);
            for (int j = 0; j < k; j++) {
                int nextValue = firstValue + j;
                if(!counter.containsKey(nextValue)){
                    return false;
                }
                int remainder = counter.get(nextValue) - 1;
                if(remainder < 0){
                    return false;
                }
                else{
                    counter.put(nextValue,remainder);
                    if(remainder == 0)
                        i++;
                }
            }
        }

        return true;
    }


}
