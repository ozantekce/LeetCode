package Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int [] array ={1,2,4};

        System.out.println(maxProfit(array));


    }




    public static int maxProfit(int[] prices) {
        DP = new int[prices.length+2][3];
        for (int i = 0; i < prices.length+2; i++) {
            for (int j = 0; j < 3; j++) {
                DP[i][j] = -1;
            }
        }

        return  recursive2(prices,0,0);
    }




    public static int DP[][]; // index , process : 1=buy, 2=sell

    public static int recursive2(int prices[],int index,int canSell){

        if(index>=prices.length){
            return 0;
        }

        if(canSell==1){

            int p1,p2;
            p1 = recursive2(prices,index+1,1);//CD
            if(DP[index][2]!=-1){
                p2 = DP[index][2];
            }else{
                DP[index][2]=p2 = prices[index]+recursive2(prices,index+2,0);//SELL
            }
            return Math.max(p1,p2);
        }else{

            int p1,p2;
            p1 = recursive2(prices,index+1,0);//CD
            if(DP[index][1]!=-1){
                p2 = DP[index][1];
            }else{
                DP[index][1]=p2 = -prices[index]+recursive2(prices,index+1,1);//BUY
            }
            return Math.max(p1,p2);
        }

    }


/*
    public static int recursive(int[] prices,int index,int profit,boolean canSell){

        if(index>=prices.length){
            return profit;
        }

        if(canSell){
            int v1,v2;
            v1 = recursive(prices,index+1,profit,canSell);//CD
            v2 = recursive(prices,index+2, profit + prices[index],!canSell);//SELL
            int max = Math.max(v1,v2);
            return max;
        }
        else{
            int v1,v2;
            v1 = recursive(prices,index+1,profit,canSell);//CD
            v2 = recursive(prices,index+1, profit - prices[index],!canSell);//BUY
            int max = Math.max(v1,v2);
            return max;
        }

    }
*/



}
