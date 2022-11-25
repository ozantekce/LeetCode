package Best_Poker_Hand_2347;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int [] ranks = {13,2,3,1,9};
        char [] suits = {'a','a','a','a','a'};

        System.out.println(bestHand(ranks,suits));

    }

    public static String bestHand(int[] ranks, char[] suits) {

        Arrays.sort(suits);
        boolean flush = true;
        char control = suits[0];
        for (int i = 1; i < suits.length; i++) {
            if(control!=suits[i]){
                flush = false;
                break;
            }
        }
        if(flush){
            return "Flush";
        }

        Arrays.sort(ranks);
        boolean pair = false;
        int current = 1;
        int contolRank = ranks[0];
        for (int i = 1; i < ranks.length; i++) {
            if(ranks[i]==contolRank){
                current++;
                if(current==3){
                    return "Three of a Kind";
                }
                pair=true;
            }else{
                contolRank = ranks[i];
                current=1;
            }

        }

        if(pair){
            return "Pair";
        }

        return "High Card";
    }



}
