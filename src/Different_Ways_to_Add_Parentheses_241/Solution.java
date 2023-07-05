package Different_Ways_to_Add_Parentheses_241;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(diffWaysToCompute("55+222-113-1"));
        //System.out.println(diffWaysToCompute("2-1-1"));
        //System.out.println(diffWaysToCompute("22-10-5"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
        System.out.println(diffWaysToCompute("1-2+3*4-5*6-7+8*9"));


    }


    private static final HashMap<String,Integer> TokenToInt = new HashMap<>();

    private static final Map<String, String> TokenMap = new HashMap<>();
    private static final char TokenFirstValue = 58;
    private static final char TokenLastValue = 255;

    private static final StringBuilder currentValue = new StringBuilder();

    public static List<Integer> diffWaysToCompute(String expression) {

        TokenMap.clear();
        TokenToInt.clear();
        currentValue.setLength(0);
        currentValue.append(TokenFirstValue);
        HashSet<String> skip = new HashSet<>();
        Queue<String> frontier = new ArrayDeque<>();
        frontier.add(expression);

        List<Integer> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (!frontier.isEmpty()){
            String current = frontier.poll();

            if(skip.contains(current))continue;
            skip.add(current);

            stringBuilder.setLength(0);
            stringBuilder.append(current);

            boolean isLeaf = true;
            for (int i = 0; i < stringBuilder.length(); i++) {

                if(isOperation(stringBuilder.charAt(i))){

                    findLeftNumber(stringBuilder,i);
                    findRightNumber(stringBuilder,i);

                    String left = stringBuilder.substring(LeftResult[0], LeftResult[1]);
                    String right = stringBuilder.substring(RightResult[0], RightResult[1]);
                    String token = getToken(stringBuilder.charAt(i),left,right);

                    String next = createNextExpression(stringBuilder,LeftResult[0],RightResult[1]
                            ,token);


                    frontier.add(next);
                    isLeaf = false;
                }
            }
            if(isLeaf){
                result.add(tokenToInt(current));
            }
        }


        return result;
    }


    public static int[] LeftResult = new int[2];
    public static void findLeftNumber(StringBuilder str, int opIndex){

        int start;
        int end = opIndex;
        int i = end-1;
        for (; i >=0 ; i--) {
            if(isOperation(str.charAt(i))){
                break;
            }
        }

        start = i+1;
        LeftResult[0] = start;
        LeftResult[1] = end;
    }


    public static int[] RightResult = new int[2];
    public static void findRightNumber(StringBuilder str, int opIndex){

        int start = opIndex+1;
        int end;
        int i = start;
        for (; i < str.length() ; i++) {
            if(isOperation(str.charAt(i))){
                break;
            }
        }
        end = i;
        RightResult[0] = start;
        RightResult[1] = end;
    }


    public static String createToken(String expression) {
        if (TokenMap.containsKey(expression)) {
            return TokenMap.get(expression);
        } else {
            incrementTokenValue();
            String cv = currentValue.toString();
            TokenMap.put(expression, cv);
            return cv;
        }
    }

    private static void incrementTokenValue() {

        int i = currentValue.length() - 1;
        while (i >= 0) {
            if (currentValue.charAt(i) != TokenLastValue) {
                currentValue.setCharAt(i, (char) (currentValue.charAt(i) + 1));
                break;
            } else {
                currentValue.setCharAt(i, TokenFirstValue);
                i--;
            }
        }
        if (i < 0) {
            currentValue.insert(0, TokenFirstValue);
        }

    }

    private static final StringBuilder rawTokenBuilder = new StringBuilder();
    public static String getToken(char op, String left, String right){

        rawTokenBuilder.setLength(0);
        rawTokenBuilder.append("(");
        rawTokenBuilder.append(left);
        rawTokenBuilder.append(op);
        rawTokenBuilder.append(right);
        rawTokenBuilder.append(")");

        String token = createToken(rawTokenBuilder.toString());
        if(TokenToInt.containsKey(token)){
            return token;
        }
        int valueOfToken = 0;
        int leftValue = tokenToInt(left);
        int rightValue = tokenToInt(right);
        if(op=='*') valueOfToken = leftValue*rightValue;
        else if(op=='/') valueOfToken = leftValue/rightValue;
        else if(op=='+') valueOfToken = leftValue+rightValue;
        else if(op=='-') valueOfToken = leftValue-rightValue;
        TokenToInt.put(token,valueOfToken);
        return token;
    }

    public static int tokenToInt(String token){
        if(!TokenToInt.containsKey(token)){
            TokenToInt.put(token,Integer.parseInt(token));
        }
        return TokenToInt.get(token);
    }


    private static StringBuilder resultBuilder = new StringBuilder();
    public static String createNextExpression(StringBuilder str, int start, int end, String token){
        resultBuilder.setLength(0);
        resultBuilder.append(str, 0, start);
        resultBuilder.append(token);
        resultBuilder.append(str, end, str.length());
        return resultBuilder.toString();
    }

    public static boolean isOperation(char c){
        return c == '*' || c== '/' || c == '+' || c=='-';
    }

}
