package Find_Minimum_in_Rotated_Sorted_Array_153;

public class Solution {


    public static void main(String[] args) {

        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
        System.out.println(findMin(new int[]{1}));
        System.out.println(findMin(new int[]{5,1,2,3,4}));

    }

    public static int findMin(int[] nums) {

        int first = 0;
        int last = nums.length-1;
        int mid = 0;
        while (last>first){
            mid = (first+last)/2;
            System.out.println("f: "+first+" l: "+last+" m: "+mid);
            int min = Math.min(nums[mid],Math.min(nums[first],nums[last]));
            if(last-first+1<=3){
                if(min==nums[mid]){
                    return nums[mid];
                }else if(min==nums[first]){
                    return nums[first];
                }else{
                    return nums[last];
                }
            }else if(min == nums[last]){
                first = mid;
            }else{
                last = mid+1;
            }
        }


        return nums[mid];
    }

}
