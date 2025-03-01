package Richest_Customer_Wealth_1672;

public class Solution {

    public static void main(String[] args) {

    }

    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int w = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                w += accounts[i][j];
            }
            res = Math.max(res, w);
        }
        return res;
    }

}
