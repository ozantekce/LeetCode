package Reverse_Bits_190;

public class Solution {

    public static void main(String[] args) {
        System.out.print(reverseBits(43261596));
    }
    
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n%2;
            n = n >> 1;
            result += bit << (31 - i);
        }
        return result;
    }
    
}
