package Construct_the_Rectangle_492;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        
        System.out.println(Arrays.toString(constructRectangle(4)));
        System.out.println(Arrays.toString(constructRectangle(37)));
        System.out.println(Arrays.toString(constructRectangle(122122)));
        
    }

    public static int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);

        for (int w = sqrt; w >= 0; w--) {
            if(area % w != 0) continue;
            return new int[]{area / w, w};
        }

        return new int[]{area, 1};
    }

}
