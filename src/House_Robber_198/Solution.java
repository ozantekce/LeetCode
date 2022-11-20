package House_Robber_198;

public class Solution {

    public static void main(String[] args) {

        int [] nums = {2,1,1,2};
        System.out.println(rob(nums));

    }

    public static int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            int op1 = nums[i-1];
            int op2 = nums[i]+nums[i-2];
            int max = Math.max(op1,op2);
            nums[i] = max;
            nums[i-1] = Math.max(nums[i-1],nums[i-2]);
        }
        return nums[nums.length-1];
    }

    /*
    //Greedy : not working
    public static int rob(int[] nums) {

        int sum=0;

        while (true){

            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            boolean allZeros = true;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=0){
                    allZeros = false;
                }
                if(nums[i]>max){
                    max = nums[i];
                    maxIndex = i;
                }
            }
            if(allZeros){
                break;
            }
            sum+=nums[maxIndex];
            nums[maxIndex] = 0;
            int nextIndex = maxIndex+1;
            int prevIndex = maxIndex-1;
            if(nextIndex<nums.length){
                nums[nextIndex] = 0;
            }
            if(prevIndex>=0){
                nums[prevIndex] = 0;
            }

        }

        return sum;
    }
    */




}
