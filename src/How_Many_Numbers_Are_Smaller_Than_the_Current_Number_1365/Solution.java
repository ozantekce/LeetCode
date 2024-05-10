package How_Many_Numbers_Are_Smaller_Than_the_Current_Number_1365;

import java.util.Arrays;

public class Solution {

    
    
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int [] counter = new int[101];
        int [] memory = new int[101];

        Arrays.fill(memory, -1);

        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }

        for (int i = 0; i < nums.length; i++) {

            if(memory[nums[i]] != -1){
                nums[i] = memory[nums[i]];
                continue;
            }
            int count = 0;
            for (int j = nums[i]-1; j >= 0; j--) {
                count += counter[j];
            }
            memory[nums[i]] = count;
            nums[i] = count;
        }

        
        return nums;
    }
    
    
}
