package Determine_the_Winner_of_a_Bowling_Game_2660;

public class Solution {


    public static void main(String[] args) {


        int [] player1 = new int[]{4,10,7,9};
        int [] player2 = new int[]{6,5,2,3};

        System.out.println(isWinner(player1, player2));



    }




    public static int isWinner(int[] player1, int[] player2) {

        int score1 = findScore(player1);
        int score2 = findScore(player2);

        return score1 == score2 ? 0 : score1 > score2 ? 1 : 2;
    }

    private static int findScore(int[] player){
        int sum = 0;
        int doubleCounter = 0;
        for (int num : player) {

            if (doubleCounter > 0) {
                sum += num * 2;
            } else {
                sum += num;
            }
            doubleCounter--;
            if (num == 10) {
                doubleCounter = 2;
            }
        }
        return sum;
    }



}
