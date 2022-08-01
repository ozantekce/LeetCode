package Coin_Change_2_518;

import java.util.*;

public class Solution {


    public static void main(String[] args){

        System.out.println(change(5,new int[]{1,2,5}));

    }



    public static int change(int amount, int[] coins){

        int [] DP = new int [amount+1];
        DP[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount - coins[i] ; j++) {
                DP[j+coins[i]] += DP[j];
            }
        }

        return DP[amount];
    }


/*
    public static int change(int amount, int[] coins) {
        counter=0;
        recursive(amount,coins,0);
        return counter;
    }

    private static int counter = 0;
    private static void recursive(int amount, int coins[], int parentIndex){

        if(amount==0){
            counter++;
            return;
        }else if(amount<0){
            return;
        }
        for (int i = parentIndex; i < coins.length; i++) {
            recursive(amount-coins[i],coins,i);
        }

    }
*/




}
