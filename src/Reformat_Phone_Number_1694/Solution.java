package Reformat_Phone_Number_1694;

public class Solution {


    public static void main(String[] args) {

        System.out.println(reformatNumber("1-23-45 6"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4-5678"));

    }

    public static String reformatNumber(String number) {

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = number.toCharArray();
        for (int i = 0; i < number.length(); i++) {
            char c = chars[i];
            if(c>=48 && c<=57){
                stringBuilder.append(c);
            }
        }

        for (int i = 0; i < stringBuilder.length();) {
            int remainder = stringBuilder.length()-i;
            if(remainder>4){
                stringBuilder.insert(i+3,'-');
                i=i+4;
            }else{
                if(remainder>3)
                stringBuilder.insert(i+2,'-');
                break;
            }
        }

        return stringBuilder.toString();
    }

}
