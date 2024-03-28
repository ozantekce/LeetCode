package Find_the_Highest_Altitude_1732;

public class Solution {


    public static void main(String[] args) {


        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));

    }


    public static int largestAltitude(int[] gain) {

        int current = 0;
        int max = 0;

        for (int j : gain) {
            current = current + j;
            max = Math.max(max, current);
        }

        return max;
    }

}
