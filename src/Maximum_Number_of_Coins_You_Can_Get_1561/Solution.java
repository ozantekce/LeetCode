package Maximum_Number_of_Coins_You_Can_Get_1561;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxCoins(new int[]{2,4,1,2,7,8}));
        System.out.println(maxCoins(new int[]{2,4,5}));
        System.out.println(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
        System.out.println(maxCoins(new int[]{7,5,7,7,8,8,5,10,7}));

    }


    public static int maxCoins(int[] piles) {

        int max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int [] counter = new int[max + 1];
        for (int i = 0; i < piles.length; i++) {
            counter[piles[i]]++;
        }

        int j = 0;
        int size = 2 * piles.length / 3;
        for (int i = counter.length-1; i >= 0; i--) {
            if(counter[i] != 0){
                for (int k = 0; k < counter[i]; k++) {
                    piles[j++] = i;
                    if(j >= size){
                        break;
                    }
                }
            }
        }
        // 1, 2, 3, 4, 5, 6, 7, 8, 9
        // 8,6,4
        int res = 0;
        for (int i = 1; i < size; i+=2) {
            res += piles[i];
        }

        return res;
    }

}
