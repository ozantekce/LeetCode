package Jump_Game_55;

public class Solution {


    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));

    }



    public static boolean canJump(int[] nums){

        if(nums.length == 1){
            return true;
        }

        boolean [] dp = new boolean[nums.length + 1];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 1; i >= 0 ; i--) {
            if(dp[i]){

                for (int j = i - 1; j >= 0; j--) {

                    int diff = i - j;
                    if(nums[j] >= diff){
                        dp[j] = true;
                        if(j == 0){
                            return true;
                        }
                    }
                }

            }
        }

        return false;
    }

    private static byte[] Memory;
    private static boolean recursive(int index, int[] nums){

        if(index >= nums.length)
            return false;
        else if(index == nums.length - 1){
            return true;
        }

        if(Memory[index] != 0){
            return Memory[index] == 1;
        }

        boolean res = false;
        for (int i = nums[index]; i >= 1; i--) {
            res |= recursive(index + i, nums);
        }
        Memory[index] = (byte) ((res == true) ? 1 : -1);
        return res;
    }


}
