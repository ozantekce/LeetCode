package Count_Number_of_Maximum_Bitwise_OR_Subsets_2044;

public class Solution {

    public static void main(String[] args) {

        System.out.println(countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(countMaxOrSubsets(new int[]{3, 2, 1, 5}));

    }


    public static int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) max |= nums[i];
        int[] valueAndCount = new int[2];
        find(nums, max, 0, valueAndCount);
        return valueAndCount[1];
    }

    public static void find(int[] nums, int max, int i, int[] valueAndCount) {
        if (i >= nums.length) return;

        if (valueAndCount[0] == max) {
            valueAndCount[1] += ((1 << (nums.length - i)) - 1);
            return;
        }

        for (; i < nums.length; i++) {
            int before = valueAndCount[0];
            valueAndCount[0] |= nums[i];
            if (valueAndCount[0] == max) valueAndCount[1]++;
            find(nums, max, i + 1, valueAndCount);
            valueAndCount[0] = before;
        }
    }

}
