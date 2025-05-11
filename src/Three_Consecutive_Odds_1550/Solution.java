package Three_Consecutive_Odds_1550;

public class Solution {

    public static void main(String[] args) {

    }

    public boolean threeConsecutiveOdds(int[] arr) {

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                counter++;
                if (counter == 3) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

}
