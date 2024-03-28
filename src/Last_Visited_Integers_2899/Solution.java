package Last_Visited_Integers_2899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(lastVisitedIntegers(new int[]{1,2,-1,-1,-1}));
        System.out.println(lastVisitedIntegers(new int[]{1,-1,2,-1,-1}));

    }


    public static List<Integer> lastVisitedIntegers(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        int l_seen = 0;
        int [] seen = new int[nums.length];

        //Arrays.fill(seen,-1);
        int k = 0;


        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            if(num == -1){
                ans.add( k >= l_seen ? -1 : seen[l_seen - 1 - k]);
                k++;
            }else{
                seen[l_seen++] = num;
                k = 0;
            }

        }

        return ans;
    }


}
