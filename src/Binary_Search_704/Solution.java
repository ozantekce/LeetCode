package Binary_Search_704;

public class Solution {


    public static void main(String[] args) {

        System.out.println(search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(search(new int[]{-1,0,3,5,9,12},2));
        System.out.println(search(new int[]{5},5));

    }

    public static int search(int[] nums, int target) {

        int f = 0;
        int l = nums.length-1;
        int m;
        while (f<=l){

            m = (f+l)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]<target){
                f = m+1;
            }else{
                l = m-1;
            }

        }

        return -1;
    }

}
