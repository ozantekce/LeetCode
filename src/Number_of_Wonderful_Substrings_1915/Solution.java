package Number_of_Wonderful_Substrings_1915;

public class Solution {

    public static void main(String[] args) {

    }



    public static long wonderfulSubstrings(String word) {

        int [] counter = new int[1024];
        char[] chars = word.toCharArray();
        counter[0] = 1;
        long sum = 0;
        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            value ^= (1<<(chars[i]-'a'));
            sum += counter[value];
            counter[value]++;
            for (int j = 0; j < 10; j++) {
                int delta = value ^ (1<<(j));
                sum += counter[delta];
            }
        }

        return sum;
    }

}
