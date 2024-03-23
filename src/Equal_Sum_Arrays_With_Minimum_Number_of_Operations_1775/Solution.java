package Equal_Sum_Arrays_With_Minimum_Number_of_Operations_1775;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(minOperations(new int[]{1,2,3,4,5,6},new int[]{1,1,2,2,2,2}));
        //System.out.println(minOperations(new int[]{1,1,1,1,1,1,1},new int[]{6}));
        //System.out.println(minOperations(new int[]{6,6},new int[]{1}));
        //System.out.println(minOperations(new int[]{5,6,4,3,1,2},new int[]{6,3,3,1,4,5,3,4,1,3,4}));
        System.out.println(minOperations(new int[]{3,3,2,4,2,6,2},new int[]{6,2,6,6,1,1,4,6,4,6,2,5,4,2,1}));

    }


    public static int minOperations(int[] nums1, int[] nums2) {
        int total1 = 0, total2 = 0;
        int[] count1 = new int[6];
        int[] count2 = new int[6];

        for (int num : nums1) {
            total1 += num;
            count1[num - 1]++;
        }
        for (int num : nums2) {
            total2 += num;
            count2[num - 1]++;
        }

        if (total1 == total2) return 0;

        // Swap logic if necessary
        if (total2 > total1) {
            int tempTotal = total1;
            total1 = total2;
            total2 = tempTotal;

            int[] tempCount = count1;
            count1 = count2;
            count2 = tempCount;
        }

        int diff = total1 - total2;
        int i_start = 0;
        int j_start = 5;
        int ops = 0;

        while (diff > 0) {
            ops++;
            int smaller = 6;
            for (int i = i_start; i < 6; i++) {
                if (count2[i] > 0) {
                    smaller = i + 1;
                    i_start = i;
                    break;
                }
            }
            int bigger = 1;
            for (int j = j_start; j >= 0; j--) {
                if (count1[j] > 0) {
                    bigger = j + 1;
                    j_start = j;
                    break;
                }
            }

            if (smaller == 6 && bigger == 1) return -1;

            int d1 = 6 - smaller;
            int d2 = bigger - 1;

            if (d2 > d1) {
                int dec = bigger - 1;
                diff -= dec;
                count1[bigger - 1]--;
                count1[0]++;
            } else {
                int inc = 6 - smaller;
                diff -= inc;
                count2[smaller - 1]--;
                count2[5]++;
            }
        }
        return ops;
    }




}
