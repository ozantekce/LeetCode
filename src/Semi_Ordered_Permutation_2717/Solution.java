package Semi_Ordered_Permutation_2717;

public class Solution {


    public static void main(String[] args) {

    }


    public static int semiOrderedPermutation(int[] nums) {

        int n = nums.length;
        int indexOfFirst = -1;
        int indexOfLast = -1;

        for (int i = 0; i < n; i++) {
            if(nums[i] == 1)
                indexOfFirst = i;
            else if(nums[i] == n)
                indexOfLast = i;
        }

        return indexOfFirst < indexOfLast ? indexOfFirst+(n-indexOfLast-1) : indexOfFirst + (n - indexOfLast-1)-1;
    }

}
