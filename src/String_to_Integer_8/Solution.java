package String_to_Integer_8;

import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(myAtoi("words and 987"));

    }

    public static int myAtoi(String s) {

        if(s.equals(""))
            return 0;
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        //STATES
        boolean plus = false;
        boolean minus = false;
        boolean digit = false;
        boolean space = false;
        char c = chars[0];
        if(c=='+'){
            plus=true;
            stringBuilder.append(c);
        }else if(c=='-'){
            minus = true;
            stringBuilder.append(c);
        }else if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'){
            digit = true;
            stringBuilder.append(c);
        }else if(c==' '){
            space = true;
        }else{
            return 0;
        }
        for (int i = 1; i < chars.length; i++) {
            c = chars[i];
            if(plus){
                if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'){
                    //add
                    plus =false;
                    digit =true;
                    stringBuilder.append(c);
                }else{
                    return 0;
                }
            }else if(minus){
                if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'){
                    //add
                    minus = false;
                    digit = true;
                    stringBuilder.append(c);
                }else{
                    return 0;
                }
            }else if(digit){
                if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'){
                    //add
                    stringBuilder.append(c);
                }else{
                    break;
                }
            }else if(space){
                if(c=='+'){
                    plus=true;
                    stringBuilder.append(c);
                }else if(c=='-'){
                    minus = true;
                    stringBuilder.append(c);
                }else if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'){
                    digit = true;
                    stringBuilder.append(c);
                }else if (c==' '){
                    space = true;
                }else{
                    break;
                }
            }


        }
        if(!digit){
            return 0;
        }
        int rst = 0;
        try {
            rst = Integer.parseInt(stringBuilder.toString());
        }catch (Exception e){
            if(stringBuilder.charAt(0)=='-'){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }

        return rst;
    }

}
