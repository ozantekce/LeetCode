package Search_in_Rotated_Sorted_Array_33;

public class Solution {


    public static void main(String[] args) {

        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},3));
        System.out.println(search(new int[]{1},1));
        System.out.println(search(new int[]{1,3},3));
        System.out.println(search(new int[]{1,3},0));
        System.out.println(search(new int[]{1,3},4));

    }

    public static int search(int[] nums, int target) {

        if(nums.length==1){
            if(nums[0]==target)return 0;
            else  return -1;
        }
        int shift = findFirst(nums);

        int first = 0;
        int last = nums.length-1;
        int mid;
        while (first<nums.length && last<nums.length &&
                first>=0 && last>=0 &&
                nums[findShiftedIndex(first,shift,nums.length)]<=nums[findShiftedIndex(last,shift,nums.length)]){

            mid = (first+last)/2;
            int midShiftedIndex = findShiftedIndex(mid,shift,nums.length);
            int midValue = nums[midShiftedIndex];
            if(midValue==target){return midShiftedIndex;}
            else if(midValue>target){
                last = mid-1;
            }else{
                first = mid+1;
            }

        }

        return -1;
    }


    public static int findShiftedIndex(int index, int shift, int length){

        int t = index+shift;
        if(t>=length){
            t-=length;
        }
        return t;
    }

    public static int findFirst(int[] nums){

        int first = 0;
        int last = nums.length-1;
        int mid;

        while (first+1!=last){

            mid = (first+last)/2;
            if(nums[mid]<nums[last]){
                last = mid;
            }else{
                first = mid;
            }
        }

        return nums[first]>nums[last]? last:first;
    }



}

