package Kids_With_the_Greatest_Number_of_Candies_1431;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) max = Math.max(candies[i], max);

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }

}
