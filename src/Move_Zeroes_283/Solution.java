package Move_Zeroes_283;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int nums [] = {0,0,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }



    public static void moveZeroes(int[] nums) {

        int p1 = 0;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[p1] = nums[i];
                p1++;
            }else{
                zeros++;
            }
        }

        for (int i = nums.length-zeros; i <nums.length ; i++) {
            nums[i] = 0;
        }

    }



    /*
    public static void moveZeroes(int[] nums) {

        int zeros = 0;
        for (int i = 0; i < nums.length-zeros; i++) {
            if(nums[i]==0){
                shift(nums,i,zeros);
                zeros++;
                i--;
            }
        }

    }

    public static void shift(int [] nums,int i,int zeros){

        for (int j = i; j < nums.length-1-zeros; j++) {
            int temp = nums[j+1];
            nums[j+1] = nums[j];
            nums[j] = temp;
            System.out.println(Arrays.toString(nums));
        }
        System.out.println("------------------------");
    }
*/


}
