package Contains_Duplicate_II_219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Solution
{


    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3},3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1},1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if(k==0)
            return false;
        HashMap<Integer, Integer> numLastIndexPair = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!numLastIndexPair.containsKey(num)){
                numLastIndexPair.put(num,i);
            }else{
                int last = numLastIndexPair.get(num);
                int dif = Math.abs(i-last);
                if(dif<=k){
                    return true;
                }
                numLastIndexPair.put(num,i);
            }

        }


        return false;
    }

}
