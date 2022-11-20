package Number_of_Common_Factors_2427;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        int a=25;
        int b=30;
        System.out.println(commonFactors(a,b));
    }

    public static int commonFactors(int a, int b) {

        int result = 0;

        int small = a;
        int big = b;
        if(b>a){
            small = b;
            big = a;
        }

        for (int i = 1; i <= Math.sqrt(small); i++) {

            if(small%i==0){

                if(i==small/i){
                    if(big%i==0){
                        result++;
                    }
                }else{
                    if(big%i==0){
                        result++;
                    }
                    if(big%(small/i)==0){
                        result++;
                    }
                }

            }

        }

        return result;

    }

}
