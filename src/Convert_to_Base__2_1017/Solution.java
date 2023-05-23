package Convert_to_Base__2_1017;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {


        //System.out.println(baseNeg2(2));
        //System.out.println(baseNeg2(3));
        //System.out.println(baseNeg2(4));
        System.out.println(baseNeg2(25));
        //System.out.println(baseNeg2(1652421));

    }

    public static String baseNeg2(int n) {

        if(n==0)return "0";
        if(n==1)return "1";

        StringBuilder stringBuilder = new StringBuilder();
        while (n!=0){
            stringBuilder.append(n&1);
            n = -(n>>1);
        }

        return stringBuilder.reverse().toString();
    }




}
