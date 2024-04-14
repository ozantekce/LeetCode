package Find_Kth_Bit_in_Nth_Binary_String_1545;

public class Solution {

    public static void main(String[] args) {

        System.out.println(findKthBit(20,12));

        //System.out.println(findKthBit(3,1));
        //System.out.println(findKthBit(4,11));
        //System.out.println(findKthBit(20,11));

    }

    // There is a sequence :
    // r:reverse and i:invert
    // S(n) = S(n-1) + 1 + ri(S(n-1))
    // S(n) = S(n-2) + 1 + ri(S(n-2)) + 1 + S(n-2) + 0 + ri(S(n-1))

    // S(n) = S(2) + ? + ri(S(2)) + ? + S(2) + ? + ri(S(2))  ....
    // and S(2) = 011 , riS(2) = 001
    // so we can find k % 8 = 1,5,6,2,3,7 directly

    public static char findKthBit(int n, int k) {

        if(k % 4 != 0){
            if(k % 8 == 1 || k % 8 == 5 || k % 8 == 6) return '0';
            else if(k % 8 == 2 || k % 8 == 3 || k % 8 == 7) return '1';
        }
        return findCharAt(n, (k / 4) - 1);
    }


    public static char findCharAt(int n, int k) {
        if (n == 1) {
            return '1';
        }
        int length = (1 << (n - 3))  - 1;
        if (k == length) {
            return '1';
        } else if (k > length) {
            return invert(findCharAt(n - 1, 2 * length - k));
        } else {
            return findCharAt(n - 1, k);
        }
    }

    private static char invert(char c) {
        return c == '0' ? '1' : '0';
    }

}
