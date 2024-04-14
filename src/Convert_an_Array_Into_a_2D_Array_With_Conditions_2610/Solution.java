package Convert_an_Array_Into_a_2D_Array_With_Conditions_2610;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(findMatrix(new int[]{1,3,4,1,2,3,1}));

    }

    public static List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int [] table = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            List<Integer> list;
            int targetList = table[num];
            if(res.size() <= targetList){
                res.add(new ArrayList<>());
            }
            list = res.get(targetList);
            list.add(num);
            table[num]++;
        }

        return res;
    }

}
