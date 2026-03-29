package Arranging_Coins_441;

public class Solution {

    
    public static void main(String[] args) {
        
        //System.out.println(arrangeCoins(5));
        //System.out.println(arrangeCoins(8));
        //System.out.println(arrangeCoins(1));
        //System.out.println(arrangeCoins(10));
        System.out.println(arrangeCoins(1804289383));
        System.out.println(arrangeCoins(2147483647));
    }
    
    
    public static int arrangeCoins(int n) {
        
        long l_n = n;
        long left = 0;
        long right = (l_n +1)/2;
        long mid;
        
        while (true) {            
            mid = left + (right - left) / 2;
            
            long low = mid * (mid + 1) / 2;
            long high = (mid + 1) * (mid + 2) / 2;
            
            if(l_n >= low && l_n < high){
                return (int)mid;
            }else if(l_n >= high){
                left = mid + 1;
            }else{
                right = mid - 1; 
            }
        }
        
    }
    
    
}
