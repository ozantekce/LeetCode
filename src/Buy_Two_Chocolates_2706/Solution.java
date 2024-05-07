package Buy_Two_Chocolates_2706;

public class Solution {


    public static void main(String[] args) {

    }

    public int buyChoco(int[] prices, int money) {

        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            if(val < min0){
                min1 = min0;
                min0 = val;
            }else if(val < min1){
                min1 = val;
            }
        }

        int total = min0 + min1;
        if(total <= money){
            return money - total;
        }
        return money;
    }

}
