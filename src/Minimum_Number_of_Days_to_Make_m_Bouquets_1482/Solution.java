package Minimum_Number_of_Days_to_Make_m_Bouquets_1482;


public class Solution {

    public static void main(String[] args) {


        //System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 1));
        //System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
        //System.out.println(minDays(new int[]{30,49,11,66,54,22,2,57,35}, 3, 3));
        //System.out.println(minDays(new int[]{97,83}, 2, 1));

    }




    public static int minDays(int[] bloomDay, int m, int k) {

        long needCount = (long) m * k;
        if (bloomDay.length < needCount) return -1;

        int maxDay = bloomDay[0];
        int minDay = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            maxDay = Math.max(bloomDay[i], maxDay);
            minDay = Math.min(bloomDay[i], minDay);
        }

        int low = minDay;
        int high = maxDay;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValidDay(bloomDay, mid, k, needCount)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private static boolean isValidDay(int[] bloomDay, int day, int k, long need) {
        int consecutive = 0;
        long collected = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                consecutive++;
                if (consecutive == k) {
                    collected += k;
                    if (collected >= need) {
                        return true;
                    }
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }

        return false;
    }




}
