package Remove_One_Element_to_Make_the_Array_Strictly_Increasing_1909;

public class Solution {


    public static void main(String[] args) {

        System.out.println(canBeIncreasing(new int[]{1,2,10,5,7}));
        System.out.println(canBeIncreasing(new int[]{2,3,1,2}));
        System.out.println(canBeIncreasing(new int[]{1,1,1}));
        System.out.println(canBeIncreasing(new int[]{1,2,3}));
        System.out.println(canBeIncreasing(new int[]{105,924,32,968}));

    }



    public static boolean canBeIncreasing(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i+1];
            if(current >= next){
                int last = Integer.MIN_VALUE;
                boolean res = true;
                for (int k = Math.max(i - 1, 0); k < nums.length; k++) {
                    if(k == i)
                        continue;
                    if(nums[k] <= last){
                        res = false;
                        break;
                    }
                    last = nums[k];
                }
                if(res){
                    return true;
                }

                last = Integer.MIN_VALUE;
                res = true;
                for (int k = Math.max(i - 1, 0); k < nums.length; k++) {
                    if(k == i + 1)
                        continue;
                    if(nums[k] <= last){
                        res = false;
                        break;
                    }
                    last = nums[k];
                }
                return res;
            }

        }

        return true;
    }


}
