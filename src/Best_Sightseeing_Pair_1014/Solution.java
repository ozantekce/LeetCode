package Best_Sightseeing_Pair_1014;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
        System.out.println(maxScoreSightseeingPair(new int[]{1,2}));

    }



    public static int maxScoreSightseeingPair(int[] values) {

        int result = 0;
        int bestSecondPart = values[values.length-1] - values.length + 1;
        for (int i = values.length-2; i >= 0; i--) {
            result = Math.max(result, values[i] + i + bestSecondPart);
            bestSecondPart = Math.max(bestSecondPart, values[i] - i);
        }

        return result;
    }

}
