package Time_Needed_to_Buy_Tickets_2073;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(timeRequiredToBuy(new int[]{84,49,5,24,70,77,87,8},3));


    }


    public static int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0;
        int i = 0;
        while (true){
            i%=tickets.length;
            if(tickets[i]==0){

            }else{
                tickets[i]--;
                time++;
                if(i==k && tickets[i]==0){
                    break;
                }

            }
            i++;
        }


        return time;
    }

}
