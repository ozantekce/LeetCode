package Count_Number_of_Bad_Pairs_2364;

import java.util.HashMap;
import java.util.List;

public class Solution {


    public static void main(String[] args) {


        System.out.println(countBadPairs(new int[]{4, 1, 3, 3}));
        System.out.println(countBadPairs(new int[]{1, 2, 3, 4, 5}));

    }


    public static long countBadPairs(int[] nums) {
        long result = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int f = nums[i] - i;
            result += nums.length - 1 - i;
            int count = counter.getOrDefault(f, 0);
            result -= count;
            counter.put(f, count + 1);
        }
        return result;
    }


}
