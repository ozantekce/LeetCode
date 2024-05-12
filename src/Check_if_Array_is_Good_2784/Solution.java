package Check_if_Array_is_Good_2784;

public class Solution {

    public static void main(String[] args) {


        System.out.println(isGood(new int[]{2, 1, 3}));
        System.out.println(isGood(new int[]{1, 3, 3, 2}));
        System.out.println(isGood(new int[]{1, 1}));
        System.out.println(isGood(new int[]{3, 4, 4, 1, 2, 1}));

    }


    public static boolean isGood(int[] nums) {

        int max = 0;
        int [] counter = new int[201];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
            max = Math.max(max, nums[i]);
        }

        if(counter[max] != 2)
            return false;

        for (int i = 1; i < max; i++) {
            if(counter[i] != 1)
                return false;
        }


        return true;
    }

}
