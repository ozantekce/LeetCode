package Third_Maximum_Number_414;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {


    public static void main(String[] args) {

        int [] nums = {1,1,1};

        System.out.println(thirdMax(nums));

    }


    public static int thirdMax(int[] nums) {

        Arrays.sort(nums);
        int [] maxs = new int[3];
        int j = 0;
        int lastVal = nums[0];
        maxs[0] = lastVal;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]!=lastVal){
                maxs[j] = nums[i];
                j++;
                if(j==3){
                    return maxs[2];
                }
            }
            lastVal = nums[i];
        }
        return maxs[0];
    }


/*
    public static int thirdMax(int[] nums) {

        TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>()
        {
            public int compare(Integer i1,Integer i2)
            {
                return i2.compareTo(i1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size()>=3){
            int i =0;
            for (int value:set) {
                i++;
                if(i==3){
                    return value;
                }
            }

        }else{
            return set.first();
        }
        return 0;
    }
*/

}
