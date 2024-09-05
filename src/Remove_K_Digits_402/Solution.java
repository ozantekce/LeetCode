package Remove_K_Digits_402;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {


        System.out.println(removeKdigits("1432219",3));
        //System.out.println(removeKdigits("10200",1));
        //System.out.println(removeKdigits("10",2));
        //System.out.println(removeKdigits("1234567890",9));
        System.out.println(removeKdigits("10001",4));
        //System.out.println(removeKdigits("4321",2));

    }

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            stack.push(num.charAt(num.length() - 1 - i));
        }

        StringBuilder result = new StringBuilder();
        while (stack.size() >= 2 && k > 0){
            char current = stack.pop();
            char next = stack.peek();
            if(current > next){
                k--;
                if(!result.isEmpty()){
                    stack.push(result.charAt(result.length()-1));
                    result.setLength(result.length()-1);
                }
            }else{
                if(result.length() != 0 || current != '0')
                    result.append(current);
            }
        }

        while (!stack.isEmpty()){
            char c = stack.pop();
            if(c == '0' && result.isEmpty())
                continue;
            result.append(c);
        }

        result.setLength(Math.max(result.length() - k, 0));

        return result.length() > 0 ? result.toString() : "0";
    }

}


}
