package Find_All_Numbers_Disappeared_in_an_Array_448;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        int [] nums ={1,1};
        System.out.println(findDisappearedNumbers(nums));

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        boolean[] set = new boolean[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            set[nums[i]] = true;
        }

        for (int i = 1; i < set.length; i++) {
            if(!set[i])
                result.add(i);
        }

        return result;
    }

}
