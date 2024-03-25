package Find_All_Duplicates_in_an_Array_442;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

    }


    public static List<Integer> findDuplicates(int[] nums) {

        boolean[] set = new boolean[nums.length+1];
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if(set[num]){
                result.add(num);
            }else {
                set[num] = true;
            }
        }
        return result;
    }


}
