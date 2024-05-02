package Largest_Positive_Integer_That_Exists_With_Its_Negative_2441;

public class Solution {


    public static void main(String[] args) {

    }


    public static int findMaxK(int[] nums) {

        int [] counter = new int[1001];
        int res = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int absNum = Math.abs(num);
            if(num > 0){
                if(counter[absNum] == -1){
                    res = Math.max(absNum, res);
                }
                counter[absNum] = 1;
            }else{
                if(counter[absNum] == 1){
                    res = Math.max(absNum, res);
                }
                counter[absNum] = -1;
            }
        }

        return res;
    }

}
