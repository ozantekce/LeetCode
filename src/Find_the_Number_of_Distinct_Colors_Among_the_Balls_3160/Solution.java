package Find_the_Number_of_Distinct_Colors_Among_the_Balls_3160;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(queryResults(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}})));

    }


    public static int[] queryResults(int limit, int[][] queries) {

        int[] result = new int[queries.length];
        HashMap<Integer, Integer> counter = new HashMap<>();
        HashMap<Integer, Integer> balls = new HashMap<>();

        int differentColorCount = 0;
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int ball = query[0];
            int oldColor = balls.getOrDefault(ball, 0);
            int newColor = query[1];

            if (oldColor != 0) {
                int oldColorCount = counter.get(oldColor);
                if (oldColorCount == 1) {
                    counter.remove(oldColor);
                    differentColorCount--;
                } else {
                    counter.put(oldColor, oldColorCount - 1);
                }
            }

            int newColorCount = counter.getOrDefault(newColor, 0) + 1;
            counter.put(newColor, newColorCount);
            if (newColorCount == 1) {
                differentColorCount++;
            }

            balls.put(ball, newColor);
            result[i] = differentColorCount;
        }

        return result;
    }

}
