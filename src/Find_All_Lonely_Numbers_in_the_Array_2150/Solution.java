package Find_All_Lonely_Numbers_in_the_Array_2150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(findLonely(new int[]{10,6,5,8}));
        System.out.println(findLonely(new int[]{1,3,5,3}));

    }


    public static List<Integer> findLonely(int[] nums) {

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] counter = new int[max+2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            counter[num]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = counter[num];
            if(count == 1 && (num - 1 == -1 || counter[num-1] == 0) && counter[num+1] == 0){
                res.add(num);
            }
        }

        return res;
    }

}
