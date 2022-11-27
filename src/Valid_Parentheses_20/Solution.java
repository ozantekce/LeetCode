package Valid_Parentheses_20;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        String s = "}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        boolean pushing;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c=='('||c=='{'||c=='[')){
                pushing = true;
            }else{
                pushing = false;
            }
            if(pushing){
                stack.push(c);
                //System.out.println(pushing+" "+stack);
            }else{
                if(stack.isEmpty())
                    return false;
                char p = stack.pop();
                //System.out.println(pushing+" "+stack);
                if(c==')'){
                    if(p!='(')
                        return false;
                }
                if(c=='}'){
                    if(p!='{')
                        return false;
                }
                if(c==']'){
                    if(p!='[')
                        return false;
                }
            }

        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
