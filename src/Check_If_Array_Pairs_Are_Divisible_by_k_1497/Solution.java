package Check_If_Array_Pairs_Are_Divisible_by_k_1497;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        //System.out.println(canArrange(new int[]{1,2,3,4,5,10,6,7,8,9},5));        // true
        //System.out.println(canArrange(new int[]{1,2,3,4,5,6},7));                 // true
        //System.out.println(canArrange(new int[]{1,2,3,4,5,6},10));                // false
        //System.out.println(canArrange(new int[]{-1,1,-2,2,-3,3,-4,4},3));         // true
        //System.out.println(canArrange(new int[]{-4,-7,5,2,9,1,10,4,-8,-3},3));   // true
        System.out.println(canArrange(new int[]{2,2,2,4},4));   // false
        /*System.out.println(canArrange(new int[]{2,3,7,-9,4,4,7,3,2,10,8,15,2,1,-8,10
                ,-5,10,-2,21,9,20,0,4,24,5,12,-10,8,9,18,13,-8,10,-4,-3,0,16,-4,8,14
                ,15,-9,0,0,-6,11,-3,10,11,7,-1,-5,5,11,2,5,9,-2,8,9,-10,6,-2,7,8,3,0,-2,11},18));   // true
*/

    }


    public static boolean canArrange(int[] arr, int k) {

        int [] counter = new int[k];
        for (int i = 0; i < arr.length; i++) {
            int r = arr[i]%k;
            if(r<0) counter[-r]--;
            else counter[r]++;
        }

        int p1 = 1;
        int p2;
        while (true){
            p2 = k-p1;
            if(p1>p2)break;
            if(p1==p2 && (counter[p1])%2!=0)return false;
            if(counter[p1]!=counter[p2])return false;
            p1++;
        }

        return true;
    }


}
