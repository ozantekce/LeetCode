package The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n_1415;

public class Solution {


    public static void main(String[] args) {

        System.out.println(getHappyString(1, 3));
        System.out.println(getHappyString(1, 4));
        System.out.println(getHappyString(3, 9));

    }


    public static String getHappyString(int n, int k) {
        char[] chars = new char[n];
        if (findHappyString(n, k, chars, 0, new Int())) {
            return new String(chars);
        } else {
            return "";
        }
    }

    private static boolean findHappyString(int n, int k, char[] chars, int offset, Int counter) {
        if (offset == n) {
            counter.value++;
            return counter.value == k;
        }
        char before = offset > 0 ? chars[offset - 1] : 0;
        for (char i = 'a'; i <= 'c'; i++) {
            if (before == i) continue;
            chars[offset] = i;
            if (findHappyString(n, k, chars, offset + 1, counter)) {
                return true;
            }
        }
        return false;
    }

    public static class Int {
        public int value;
    }

}
