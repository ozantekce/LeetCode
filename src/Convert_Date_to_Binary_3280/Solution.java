package Convert_Date_to_Binary_3280;

public class Solution {


    public static void main(String[] args) {

        System.out.println(convertDateToBinary("2080-02-29"));

    }

    public static String convertDateToBinary(String date) {
        int num = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if (c == '-') {
                result.append(Integer.toBinaryString(num));
                result.append('-');
                num = 0;
            } else {
                num *= 10;
                num += c - '0';
            }
        }
        result.append(Integer.toBinaryString(num));
        return result.toString();
    }

}
