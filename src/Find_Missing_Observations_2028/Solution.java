package Find_Missing_Observations_2028;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
        System.out.println(Arrays.toString(missingRolls(new int[]{1,5,6}, 3, 4)));
        System.out.println(Arrays.toString(missingRolls(new int[]{1,2,3,4}, 6, 4)));

    }




    public static int[] missingRolls(int[] rolls, int mean, int n) {


        int sum = mean * (rolls.length + n);

        for (int i = 0; i < rolls.length; i++) {
            sum -= rolls[i];
        }

        if(sum < n) return new int[]{};

        int add = sum / n;

        if(add > 6 || add == 0) return new int[]{};

        int [] result = new int[n];
        Arrays.fill(result, add);

        int remainder = sum - (add * n);

        int i = 0;
        while (remainder > 0 && i < n){
            add = Math.min(6 - result[i], remainder);
            result[i] += add;
            remainder -= add;
            i++;
        }

        if(remainder > 0) return new int[]{};

        return result;
    }



}
