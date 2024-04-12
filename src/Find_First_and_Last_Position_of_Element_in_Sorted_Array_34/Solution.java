package Find_First_and_Last_Position_of_Element_in_Sorted_Array_34;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,4}, 4)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));

    }

    public static int[] searchRange(int[] nums, int target) {
        int [] res = new int[]{-1,-1};

        int left = 0;
        int right = nums.length - 1;
        while (true){
            int mid = BinarySearch(nums, left, right, target);
            if(mid != -1){
                res[0] = mid;
                right = mid - 1;
            }
            else{
                break;
            }
        }

        left = res[0] != -1 ? res[0] : 0;
        right = nums.length - 1;
        while (true){
            int mid = BinarySearch(nums, left, right, target);
            if(mid != -1){
                res[1] = mid;
                left = mid + 1;
            }
            else{
                break;
            }
        }


        return res;
    }

    private static int BinarySearch(int[] nums, int left, int right, int target){

        int mid;
        while (left <= right){
            mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }


}
