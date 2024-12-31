package Minimum_Cost_For_Tickets_983;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {


        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println(mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
        System.out.println(mincostTickets(new int[]{1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,21,24,25,27,28,29,30,31,34,37,38,39,41,43,44,45,47,48,49,54,57,60,62,63,66,69,70,72,74,76,78,80,81,82,83,84,85,88,89,91,93,94,97,99}, new int[]{9,38,134}));  //423

    }

    public static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        boolean [] validDays = new boolean[lastDay+1];
        int [] dp = new int[lastDay+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < days.length; i++){
            validDays[days[i]] = true;
        }

        for (int i = 1; i <= lastDay; i++) {
            if(!validDays[i]){
                dp[i] = dp[i-1];
                continue;
            }
            int selected1 = dp[i-1] + costs[0];
            int selected7 = dp[Math.max(i-7, 0)] + costs[1];
            int selected30 = dp[Math.max(i-30, 0)] + costs[2];

            dp[i] = Math.min(selected1, Math.min(selected7, selected30));
        }


        return dp[lastDay];
    }



    private static int Memo [];

    public static int mincostTickets_Recursive(int[] days, int[] costs) {
        Memo = new int[days[days.length-1] + 1];
        Arrays.fill(Memo, -1);
        return recursive(1,0, days, costs);
    }


    private static int recursive(int startDay, int index, int[] days, int[] costs){

        if(index >= days.length || startDay > days[days.length-1])
            return 0;
        else if(Memo[startDay] != -1)
            return Memo[startDay];

        while (startDay > days[index]){
            index++;
            if(index >= days.length) return 0;
        }

        int endDay = days[index];

        int min = Integer.MAX_VALUE;
        for (int i = startDay; i <= endDay; i++) {
            int selected1 = costs[0] + recursive(i+1, index, days, costs);
            int selected7 = costs[1] + recursive(i+7,index, days, costs);
            int selected30 = costs[2] + recursive(i+30,index, days, costs);
            min = Math.min(Math.min(min, selected1), Math.min(selected7, selected30));
        }

        return Memo[startDay] = min;
    }




}
