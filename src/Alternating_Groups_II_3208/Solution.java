package Alternating_Groups_II_3208;

public class Solution {

    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6));
        System.out.println(numberOfAlternatingGroups(new int[]{1, 1, 0, 1}, 4));
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 1}, 3));
        System.out.println(numberOfAlternatingGroups(new int[]{0, 0, 0}, 3));
    }


    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int counter = 1;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i - 1] == colors[i]) {
                counter = 1;
            } else {
                counter++;
                if (counter >= k) res++;
            }
        }

        if (colors[colors.length - 1] == colors[0]) {
            counter = 1;
        } else {
            counter++;
            if (counter >= k) res++;
        }

        for (int i = 1; i < k - 1; i++) {
            if (colors[i - 1] == colors[i]) {
                counter = 1;
            } else {
                counter++;
                if (counter >= k) res++;
            }
        }

        return res;
    }
}
