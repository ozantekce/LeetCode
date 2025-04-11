package Count_Symmetric_Integers_2843;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(countSymmetricIntegers(1, 100));
        System.out.println(countSymmetricIntegers(2, 11));

    }


    public static int countSymmetricIntegers(int low, int high) {

        int counter = 0;

        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            if (s.length() % 2 == 1 && i % 10 == 0) {
                i *= 10;
                i--;
                continue;
            }
            int left = 0;
            int right = 0;
            int n = s.length() / 2;
            for (int j = 0; j < n; j++) left += s.charAt(j) - '0';
            for (int j = n; j < s.length(); j++) right += s.charAt(j) - '0';
            if (left == right) {
                counter++;
            }
        }

        return counter;
    }

}
