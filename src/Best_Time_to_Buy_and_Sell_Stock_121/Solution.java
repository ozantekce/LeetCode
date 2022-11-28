package Best_Time_to_Buy_and_Sell_Stock_121;

public class Solution {


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }


    public static int maxProfit(int[] prices) {


        int max = prices[prices.length-1];
        int maxProfit = 0;
        for (int i = prices.length-2; i >=0 ; i--) {
            int profit = max-prices[i];
            if(profit>maxProfit){
                maxProfit = profit;
            }
            if(max<prices[i]){
                max = prices[i];
            }

        }

        return maxProfit;
    }

}
