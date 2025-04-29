package Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times_2962;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        System.out.println(countSubarrays(new int[]{61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82}, 2));
        //System.out.println(countSubarrays(new int[]{1, 4, 2, 1}, 3));

    }

    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        int max = nums[0];
        int maxIndicesSize = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndicesSize = 1;
            } else if (nums[i] == max) {
                maxIndicesSize++;
            }
        }

        int[] maxIndices = new int[maxIndicesSize];
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) maxIndices[pointer++] = i;
        }

        int offset = 0;
        int start = 0;
        while (start < n && maxIndicesSize - offset >= k) {
            int minEndIndex = maxIndices[offset + k - 1];
            int maxEndIndex = n - 1;
            int next = maxIndices[offset];
            long diff = maxEndIndex - minEndIndex + 1;
            res += (next - start + 1) * diff;
            start = next + 1;
            offset++;
        }
        return res;
    }

}
