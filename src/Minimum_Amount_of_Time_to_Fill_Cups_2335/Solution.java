package Minimum_Amount_of_Time_to_Fill_Cups_2335;

public class Solution {


    public static void main(String[] args) {

        int array [] = {1,4,2};
        System.out.println(fillCups(array));

    }

    public static int fillCups(int[] amount) {

        int cold;
        int warm;
        int hot;

        cold = amount[0];
        warm = amount[1];
        hot = amount[2];

        int n = 0;

        while (true){

            if(cold ==0 && warm==0 && hot ==0){return n;}

            int min = Math.min(hot,Math.min(cold,warm));

            if(min==cold){
                n++;
                if(warm!=0){
                    warm--;
                }
                if(hot!=0){
                    hot--;
                }

            }else if(min==warm){
                n++;
                if(cold!=0){
                    cold--;
                }
                if(hot!=0){
                    hot--;
                }
            }else if(min==hot){
                n++;
                if(cold!=0){
                    cold--;
                }
                if(warm!=0){
                    warm--;
                }
            }


        }


    }

}
