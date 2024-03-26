package Neither_Minimum_nor_Maximum_2733;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(findNonMinOrMax(new int[]{3,2,1,4}));
        //System.out.println(findNonMinOrMax(new int[]{1,2}));
        //System.out.println(findNonMinOrMax(new int[]{2,1,3}));
        System.out.println(findNonMinOrMax(new int[]{3,30,24}));

    }


    public static int findNonMinOrMax(int[] nums) {

        if(nums.length<=2) return -1;

        int result = -1;
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            if(num<min){
                result = min;
                min = num;
            }else if(num>max){
                result = max;
                max = num;
            }else{
                result = num;
            }

        }
        return result;
    }


}
