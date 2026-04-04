package Max_Consecutive_Ones_485;

public class Solution {


    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
    
    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if(c == 1){
                counter++;
            }else{
                result = Math.max(counter, result);
                counter = 0;
            }
        }
        result = Math.max(counter, result);
        return result;
    }
    
}
