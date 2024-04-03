package Stone_Game_II_1140;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(stoneGameII(new int[]{2,7,9,4,4}));
        System.out.println(stoneGameII(new int[]{1,2,3,4,5,100}));
        //System.out.println(stoneGameII(new int[]{1}));
        //System.out.println(stoneGameII(new int[]{1,1,1}));
        //System.out.println(stoneGameII(new int[]{3111,4303,2722,2183,6351,5227,8964,7167,9286,6626,2347,1465,5201,7240,5463,8523,8163,9391,8616,5063,7837,7050,1246,9579,7744,6932,7704,9841,6163,4829,7324,6006,4689,8781,621}));

    }


    private static int Memory [][];

    public static int stoneGameII(int[] piles) {
        Memory = new int[piles.length+1][piles.length];
        for (int[] ints : Memory) {
            Arrays.fill(ints, -1);
        }
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        int diff = recursive(piles, 0, 1, true);
        return (sum+diff)/2;
    }



    private static int recursive(int [] nums, int i, int m, boolean turn){
        if(i >= nums.length){
            return 0;
        }
        if(Memory[m][i] != -1)
            return turn ? Memory[m][i] : -Memory[m][i];

        int max = Integer.MIN_VALUE;
        int c = 0;
        for (int j = 1; j <= 2 * m; j++) {
            if(i+j > nums.length){
                break;
            }
            c += nums[i+j-1];
            max = Math.max(max, c + recursive(nums, i + j, Math.max(m, j), false));
        }
        Memory[m][i] = max;
        return turn ? max : -max;
    }


}
