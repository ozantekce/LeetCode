package Find_the_Duplicate_Number_287;

public class Solution {

    public static void main(String[] args) {

        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{5,1,5,4,2,3}));
        System.out.println(findDuplicate(new int[]{2,1,1}));

    }

    public static int findDuplicate(int[] nums) {

        // Finding max value in array
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
        }
        // Creating control array
        boolean [] control = new boolean[max+1];
        // Checking
        for (int i = 0; i < nums.length; i++) {
            // if value already added return value
            if(control[nums[i]]){
                return nums[i];
            }
            // else add value
            control[nums[i]] = true;
        }

        return 0;
    }

}
