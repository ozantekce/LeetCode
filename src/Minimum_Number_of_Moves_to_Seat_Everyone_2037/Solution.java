package Minimum_Number_of_Moves_to_Seat_Everyone_2037;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minMovesToSeat(new int[]{3,1,5}, new int[]{2,7,4}));
        System.out.println(minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6}));

    }


    public static int minMovesToSeat(int[] seats, int[] students) {

        Arrays.sort(seats);
        Arrays.sort(students);

        int res = 0;
        int n = seats.length;

        for (int i = 0; i < n; i++) {
            res += Math.abs(seats[i] - students[i]);
        }


        return res;
    }


}
