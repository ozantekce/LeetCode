package _2_Keys_Keyboard_650;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minSteps(4830));

    }


    public static int minSteps(int n) {


        if(n==1){
            return 0;
        }
        if(n<=4){
            return n;
        }
        // if n is a prime number, return n
        // else find the biggest prime number by dividing and record the multiplier
        // then return record + the biggest prime
        int add = 0;
        int N = n;
        while (true){
            int maxDivider = n;
            for (int i = n/2; i > 1 ; i--) {
                if(n%i==0){
                    maxDivider = i;
                    break;
                }
            }
            if(maxDivider== n){
                break;
            }
            add += (n/maxDivider);
            n = maxDivider;
        }

        if(N == n){
            return N;
        }else{
            return n + add;
        }

    }





}
