package Count_Special_Quadruplets_1995;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {


        //System.out.println(countQuadruplets(new int[]{1,2,3,6}));
        //System.out.println(countQuadruplets(new int[]{3,3,6,4,5}));
        //System.out.println(countQuadruplets(new int[]{1,1,1,3,5}));
        System.out.println(countQuadruplets(new int[]{9,6,8,23,39,23}));

    }


    public static int countQuadruplets(int[] nums) {

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int si = nums[i];
            if(si >= 100) continue;
            for (int j = i+1; j < nums.length; j++) {
                int sj = si + nums[j];
                if(sj >= 100) continue;
                for (int k = j+1; k < nums.length; k++) {
                    int sk = sj + nums[k];
                    if(sk >= 101) continue;
                    for (int l = k+1; l < nums.length; l++) {
                        if(nums[l] == sk){
                            res++;
                        }
                    }
                }
            }
        }

        return res;
    }


}
