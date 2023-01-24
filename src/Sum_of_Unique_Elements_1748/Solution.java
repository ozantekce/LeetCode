package Sum_of_Unique_Elements_1748;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {

        System.out.println(sumOfUnique(new int[]{1,2,3,2}));

    }

    public static int sumOfUnique(int[] nums) {

        int counter [] = new int[101];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if(counter[i]==1){
                sum+=i;
            }
        }

        return sum;
    }


}
