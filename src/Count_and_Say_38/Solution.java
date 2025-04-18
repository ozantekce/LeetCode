package Count_and_Say_38;

public class Solution {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        return find("1", n);
    }

    public static String find(String str, int n) {
        if (n == 1) return str;

        StringBuilder result = new StringBuilder();
        int counter = 1;
        char l = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == l) {
                counter++;
            } else {
                result.append(counter);
                result.append(l);
                counter = 1;
                l = str.charAt(i);
            }
        }
        result.append(counter);
        result.append(l);
        return find(result.toString(), n - 1);
    }
}
