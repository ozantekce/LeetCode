package Add_Strings_415;

public class Solution {


    public static void main(String[] args) {

        String s1 = "456";
        String s2 = "77";
        System.out.println(addStrings(s1,s2));

    }


    public static String addStrings(String num1, String num2) {
        char [] chars1 = num1.toCharArray();
        char [] chars2 = num2.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        char carry = 48;
        for (int i = chars1.length-1,j=chars2.length-1; i>=0 || j>=0; i--,j--) {
            char c1 = i>=0? chars1[i]:'0';
            char c2 = j>=0? chars2[j]:'0';
            char sum = (char) (carry-48+c1-48+c2);
            if(sum>=(68)){
                sum -= 20;
                carry = 50;
            }else if(sum>=(58)){
                sum -= 10;
                carry = 49;
            }else{
                carry = 48;
            }
            stringBuilder.append(sum);
        }
        if(carry!=48)
            stringBuilder.append(carry);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

}
