package Wiggle_Sort_II_324;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int nums [] = new int[]{1,1,2,1,2,2,1};
        wiggleSort(nums);
    }

    public static void wiggleSort(int[] nums) {

        Arrays.sort(nums);
        int result [] = new int[nums.length];
        int front = 0;
        int back = nums.length-1;
        int i =0;
        int firstEven = nums.length-1;
        if(firstEven%2!=0){
            firstEven--;
        }
        while (front<=back){
            if(front!=back)
                result[2*i+1] = nums[back];
            result[firstEven-2*i] = nums[front];
            i++;
            back--;
            front++;
        }
        for (i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
        //System.out.println(Arrays.toString(result));
    }


}
