package Different_Ways_to_Add_Parentheses_241;

import java.util.*;

public class Solution2 {


    public static void main(String[] args) {

        long start = System.nanoTime();
        System.out.println(diffWaysToCompute("55+222-113-1"));
        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("22-10-5"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
        System.out.println(diffWaysToCompute("1-2+3*4-5*6-7+8*9"));

        long end = System.nanoTime();

        System.out.println("Time taken: " + ((end - start)/1000000d) + " ms");


    }


    private static List<Integer> Numbers = new ArrayList<>();
    private static List<Character> Operations = new ArrayList<>();
    private static List<Integer> [][] Memory;
    public static void FindNumbersAndOperations(String exp){
        Numbers.clear();
        Operations.clear();
        StringBuilder number = new StringBuilder();
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c)) {
                number.append(c);
            } else if(isOperation(c)) {
                if (number.length() > 0) {
                    Numbers.add(Integer.parseInt(number.toString()));
                    number = new StringBuilder();
                }
                Operations.add(c);
            }
        }
        if (number.length() > 0) {
            Numbers.add(Integer.parseInt(number.toString()));
        }
        Memory = new ArrayList[Numbers.size()][Numbers.size()];
    }

    public static List<Integer> Find(int start, int end){

        if(Memory[start][end]!=null){
            return Memory[start][end];
        }
        if(start==end){
            Memory[start][end] = new ArrayList<>(List.of(Numbers.get(start)));
            return Memory[start][end];
        }
        if (start+1 == end) {
            Memory[start][end] = executeOperation(
                    Operations.get(start)
                    , List.of(Numbers.get(start))
                    , List.of(Numbers.get(end)));
            return Memory[start][end];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.addAll(Find(start,i,i+1,end));
        }
        Memory[start][end] = result;
        return result;
    }

    public static List<Integer> Find(int start1, int end1, int start2 , int end2){
        return executeOperation(Operations.get(end1), Find(start1,end1), Find(start2,end2));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        FindNumbersAndOperations(expression);
        return Find(0,Numbers.size()-1);
    }


    private static final Set<Character> operations = Set.of('*', '/', '+', '-');

    public static boolean isOperation(char c){
        return operations.contains(c);
    }

    public static List<Integer> executeOperation(char op, List<Integer> l1, List<Integer> l2){

        List<Integer> result = new ArrayList<>(l1.size()*l2.size());

        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                if(op=='+'){
                    result.add(l1.get(i)+l2.get(j));
                }else if(op == '-'){
                    result.add(l1.get(i)-l2.get(j));
                }else if(op == '*'){
                    result.add(l1.get(i)*l2.get(j));
                }else{
                    result.add(l1.get(i)/l2.get(j));
                }
            }
        }

        return result;
    }

}
