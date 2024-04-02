package Stone_Game_877;

public class Solution {

    public static void main(String[] args) {

        System.out.println(stoneGame(new int[] {5,5,5,5,5,5}));     // true
        System.out.println(stoneGame(new int[] {5,9999,5,5,5,5}));  // true
        System.out.println(stoneGame(new int[] {5,5,9999,5,5,5}));  // true
        System.out.println(stoneGame(new int[] {5,5,5,9999,5,5}));  // true
        System.out.println(stoneGame(new int[] {5,5,5,5,9999,5}));  // true
        //System.out.println(stoneGame(new int[] {3,7,2,3}));

    }


    public static boolean stoneGame(int[] piles) {
        // we have even number of piles so Alice always wins.
        return true;
        //System.out.println(recursive(0, piles, 0, piles.length-1,0));
        //return recursive(0, piles, 0, piles.length-1,0) > 0;
    }


    private static int recursive(int a, int [] nums, int i, int j, int seq){

        if(i == j){
            return a - nums[i];
        }


        if(seq % 2 == 0){
            return Math.max(recursive(a+nums[i],nums,i+1,j,seq+1),
                    recursive(a+nums[j],nums,i,j-1,seq+1));
        }
        else{
            return Math.min(recursive(a-nums[i],nums,i+1,j,seq+1),
                    recursive(a-nums[j],nums,i,j-1,seq+1));
        }
    }

}
