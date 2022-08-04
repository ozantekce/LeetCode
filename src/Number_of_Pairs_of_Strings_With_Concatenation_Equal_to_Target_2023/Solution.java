package Number_of_Pairs_of_Strings_With_Concatenation_Equal_to_Target_2023;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        String[] nums = {"1","111"};
        String target = "11";
        System.out.println(numOfPairs(nums,target));

    }

    // O(n^2)
    public static int numOfPairs(String[] nums, String target) {

        int counter =0;
        int targetLength = target.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if(i==j || (nums[i].length() +nums[j].length()) !=targetLength )
                    continue;
                stringBuilder.delete(0,stringBuilder.length());
                stringBuilder.append(nums[i]);
                stringBuilder.append(nums[j]);
                if(stringBuilder.toString().equals(target)){
                    counter++;
                }
            }
            
        }
        
        return counter;
    }

}
