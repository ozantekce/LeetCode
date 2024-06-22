package Magnetic_Force_Between_Two_Balls_1552;

import java.util.Arrays;


public class Solution {


    public static void main(String[] args) {

        System.out.println(maxDistance(new int[]{1,2,3,4,7}, 3));
        //System.out.println(maxDistance(new int[]{5,4,3,2,1,5,4,3,2,1,1000000000}, 2));
        //System.out.println(maxDistance(new int[]{1,2,3,4,5,6,7,8,9,10}, 4));

    }

    public static int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int low = 1;
        int high = (position[position.length-1] - position[0]) / (m - 1);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValidForce(position, m, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }


    private static boolean isValidForce(int[] position, int m, int force){

        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            int currentPos = position[i];
            if(currentPos - lastPos >= force){
                m--;
                lastPos = currentPos;
                if (m == 1) return true;
            }
        }
        return false;
    }




}
