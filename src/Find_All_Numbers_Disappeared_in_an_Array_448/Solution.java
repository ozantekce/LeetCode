package Find_All_Numbers_Disappeared_in_an_Array_448;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int [] nums ={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>(nums.length);
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i < nums.length+1; i++) {
            if(!set.contains(i)){
                list.add(i);
            }
        }

        return list;
    }

}
