package Two_Furthest_Houses_With_Different_Colors_2078;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

    }

    public static int maxDistance(int[] colors) {

        int res = 0;
        int first = colors[0];
        int last = colors[colors.length - 1];

        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            if (first != color) {
                res = Math.max(res, i);
            }
            if (last != color) {
                res = Math.max(res, colors.length - i - 1);
            }
        }

        return res;
    }

}
