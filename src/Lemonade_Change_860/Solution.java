package Lemonade_Change_860;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int bills[] ={5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};

        System.out.println(lemonadeChange(bills));

    }

    public static boolean lemonadeChange(int[] bills) {

        int fives = 0;
        int tens = 0;

        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                fives++;
            }else if(bills[i]==10){
                fives--;
                tens++;
            }else{
                if(tens>0&&fives>0){
                    tens--;
                    fives--;
                }else{
                    fives-=3;
                }
            }
            if(fives<0||tens<0){
                return false;
            }
        }

        return true;
    }

}
