package Minimum_Cost_to_Move_Chips_to_The_Same_Position_1217;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        System.out.println(minCostToMoveChips(new int[]{6,4,7,8,2,10,2,7,9,7}));

    }

    public static int minCostToMoveChips(int[] position) {

        int costEven = 0;
        int costOdd = 0;

        // find cost
        for (int i = 0; i < position.length; i++) {
            if(position[i]%2==1){
                costOdd++;
            }else{
                costEven++;
            }
        }

        return Math.min(costEven,costOdd);
    }

}
