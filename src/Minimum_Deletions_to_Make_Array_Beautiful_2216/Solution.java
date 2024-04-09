package Minimum_Deletions_to_Make_Array_Beautiful_2216;

public class Solution {

    public static void main(String[] args) {

        System.out.println(minDeletion(new int[]{1,1,2,3,5}));
        System.out.println(minDeletion(new int[]{1,1,2,2,3,3}));

    }



    public static int minDeletion(int[] nums) {
        int deleteCount = 0;
        boolean isEven = true;
        for (int i = 0; i < nums.length-1; i++) {
            if(isEven){
                if(nums[i] == nums[i+1]){
                    deleteCount++;
                }else{
                    isEven = false;
                }
            }else{
                isEven = true;
            }
        }

        if(isEven)
            deleteCount++;

        return deleteCount;
    }

}
