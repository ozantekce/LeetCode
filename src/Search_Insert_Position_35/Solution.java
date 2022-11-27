package Search_Insert_Position_35;

public class Solution {


    public static void main(String[] args) {

        int nums [] = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums,target));

    }

    public static int searchInsert(int[] nums, int target) {



        int first = 0;
        int last = nums.length-1;

        while (first<last){
            int mid = (first+last)/2;
            if(target<nums[mid]){
                last = mid;
            }else if(target>nums[mid]){
                first = mid+1;
            }else{
                return mid;
            }

        }

        int mid = ((first+last)/2);
        if(nums[mid]<target)
            return mid+1;
        else
            return mid;
    }

}
