package Maximum_Distance_Between_a_Pair_of_Values_1855;

public class Solution {

    public static void main(String[] args) {

        System.out.println(maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));
        System.out.println(maxDistance(new int[]{2, 2, 2}, new int[]{10, 10, 1}));
        System.out.println(maxDistance(new int[]{30, 29, 19, 5}, new int[]{25, 25, 25, 25, 25}));

    }


    public static int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int res = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums2[j] >= nums1[i]) {
                res = Math.max(j - i, res);
            } else {
                i++;
            }
            j++;
        }

        return res;
    }

}
