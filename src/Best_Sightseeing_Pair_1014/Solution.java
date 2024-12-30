package Best_Sightseeing_Pair_1014;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
        System.out.println(maxScoreSightseeingPair(new int[]{1,2}));

    }



    public static int maxScoreSightseeingPair(int[] values) {

        int [] bestSecondParts = new int[values.length];

        bestSecondParts[values.length-1] = values[values.length-1] - (values.length-1);
        for (int i = values.length-2; i >= 1; i--) {
            bestSecondParts[i] = Math.max(bestSecondParts[i+1], values[i] - i);
        }

        int result = 0;
        for (int i = 0; i < values.length-1; i++) {
            int firstPart = values[i] + i;
            int total = firstPart + bestSecondParts[i+1];
            result = Math.max(total, result);
        }

        return result;
    }

}
