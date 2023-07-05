package Different_Ways_to_Add_Parentheses_241;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(diffWaysToCompute("55+222-113-1"));
        System.out.println(diffWaysToCompute("2-1-1"));
        //System.out.println(diffWaysToCompute("22-10-5"));
        System.out.println(diffWaysToCompute("2*3-4*5"));

    }


    static HashMap<String,Integer> Tokens = new HashMap<>();

    public static List<Integer> diffWaysToCompute(String expression) {


        HashSet<String> skip = new HashSet<>();
        Queue<String> frontier = new ArrayDeque<>();
        frontier.add(expression);

        List<Integer> result = new ArrayList<>();

        while (!frontier.isEmpty()){
            String current = frontier.poll();
            if(skip.contains(current))continue;
            skip.add(current);
            //System.out.println("C : "+current);
            int bracketsControl = 0;
            int childs = 0;
            for (int i = 0; i < current.length(); i++) {
                if(current.charAt(i)=='('){
                    bracketsControl++;
                }else if(current.charAt(i)==')'){
                    bracketsControl--;
                }
                if(isOperarion(current.charAt(i)) && bracketsControl==0){
                    findLeftNumber(current,i);
                    findRightNumber(current,i);
                    String left = current.substring(LeftResult[0], LeftResult[1]);
                    String right = current.substring(RightResult[0], RightResult[1]);
                    String merge = createToken(current.charAt(i),left,right);
                    //System.out.println(left+" "+current.charAt(i)+" "+right);
                    //System.out.println(toInteger(current.charAt(i),left,right));
                    String next = mergeLeftRight(current,LeftResult[0],RightResult[1]
                            ,merge);
                    //System.out.println("next : "+next);

                    frontier.add(next);
                    childs++;
                }
            }
            if(childs==0){
                result.add(tokenToInt(current));
            }
        }



        return result;
    }


    public static int[] LeftResult = new int[2];
    public static void findLeftNumber(String str, int opIndex){

        int start;
        int end = opIndex;
        int i = end-1;
        int bracketsControl = 0;
        for (; i >=0 ; i--) {
            if(str.charAt(i)=='('){
                bracketsControl++;
            }else if(str.charAt(i)==')'){
                bracketsControl--;
            }
            if(isOperarion(str.charAt(i)) && bracketsControl == 0){
                break;
            }
        }
        start = i+1;
        LeftResult[0] = start;
        LeftResult[1] = end;
    }


    public static int[] RightResult = new int[2];
    public static void findRightNumber(String str, int opIndex){

        int start = opIndex+1;
        int end;
        int i = start;
        int bracketsControl = 0;
        for (; i < str.length() ; i++) {
            if(str.charAt(i)=='('){
                bracketsControl++;
            }else if(str.charAt(i)==')'){
                bracketsControl--;
            }
            if(isOperarion(str.charAt(i))&& bracketsControl == 0){
                break;
            }
        }
        end = i;
        RightResult[0] = start;
        RightResult[1] = end;
    }


    public static String createToken(char op, String left, String right){

        String token = "("+left+op+right+")";
        int valueOfToken = 0;
        int leftValue = tokenToInt(left);
        int rightValue = tokenToInt(right);
        if(op=='*') valueOfToken = leftValue*rightValue;
        else if(op=='/') valueOfToken = leftValue/rightValue;
        else if(op=='+') valueOfToken = leftValue+rightValue;
        else if(op=='-') valueOfToken = leftValue-rightValue;
        Tokens.put(token,valueOfToken);
        return token;
    }

    public static int tokenToInt(String token){
        if(!Tokens.containsKey(token)) return Integer.parseInt(token);
        return Tokens.get(token);
    }



    public static String mergeLeftRight(String str, int start, int end, String value){
        String prefix = str.substring(0,start);
        String posix = "";
        posix = str.substring(end,str.length());
        String result = prefix + value + posix;

        return result;
    }

    public static boolean isOperarion(char c){
        return c == '*' || c== '/' || c == '+' || c=='-';
    }

}
