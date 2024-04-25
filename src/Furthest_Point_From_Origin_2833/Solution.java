package Furthest_Point_From_Origin_2833;

public class Solution {


    public static void main(String[] args) {

    }


    public static int furthestDistanceFromOrigin(String moves) {
        
        int res = 0;
        int remainder = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if(c == 'L'){
                res--;
            }else if(c == 'R'){
                res++;
            }else{
                remainder++;
            }
        }
        res = Math.abs(res) + remainder;
        return res;
    }

}
