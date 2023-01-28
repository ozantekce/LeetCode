package Fair_Candy_Swap_888;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(fairCandySwap(new int[]{2},new int[]{1,3})));

    }


    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int result [] = new int[2];

        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int sumAlice =0;
        int sumBob = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            sumAlice += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            sumBob += bobSizes[i];
        }

        int indexA = 0;
        int indexB = 0;

        while (true){
            int newSumAlice = sumAlice - aliceSizes[indexA] + bobSizes[indexB];
            int newSumBob = sumBob + aliceSizes[indexA] - bobSizes[indexB];
            int dif = newSumAlice - newSumBob;
            if(dif==0){
                result[0] = aliceSizes[indexA];
                result[1] = bobSizes[indexB];
                return result;
            }
            else if(dif>0){
                indexA++;
            }else {
                indexB++;
            }

        }


    }


}
