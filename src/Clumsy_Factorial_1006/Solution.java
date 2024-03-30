package Clumsy_Factorial_1006;

import java.util.Stack;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ExpressionTree ex = new ExpressionTree();
        ex.add(10);
        ex.add(Operator.Mul.getValue());
        ex.add(9);
        ex.add(Operator.Div.getValue());
        ex.add(8);
        ex.add(Operator.Sum.getValue());
        ex.add(7);
        ex.add(Operator.Sub.getValue());
        ex.add(6);
        ex.add(Operator.Mul.getValue());
        ex.add(5);
        ex.add(Operator.Div.getValue());
        ex.add(4);
        ex.add(Operator.Sum.getValue());
        ex.add(3);
        ex.add(Operator.Sub.getValue());
        ex.add(2);
        ex.add(Operator.Mul.getValue());
        ex.add(1);

        System.out.println(ex.evaluate());
        System.out.println(clumsy(10));
    }


    public static int clumsy(int n) {
        if (n == 0) {
            return 0;
        }
        int topIndex = 0;
        int[] stack = new int[n];
        stack[topIndex] = n--;

        int index = 0;
        while (n > 0) {
            if (index % 4 == 0) {
                stack[topIndex] *= n;
            } else if (index % 4 == 1) {
                stack[topIndex] /= n;
            } else if (index % 4 == 2) {
                stack[++topIndex] = n;
            } else {
                stack[++topIndex] = -n;
            }
            n--;
            index++;
        }

        int result = stack[0];
        for (int i = 1; i <= topIndex; i++) {
            result += stack[i];
        }
        return result;
    }



    public static int clumsyTreeSolution(int n) {

        Operator [] operators = new Operator[]{Operator.Mul, Operator.Div, Operator.Sum, Operator.Sub};
        int j = 0;
        ExpressionTree tree = new ExpressionTree();
        tree.add(n);
        for (int i = n-1; i > 0; i--) {
            tree.add(operators[j++].getValue());
            if(j>=operators.length)
                j = 0;
            tree.add(i);
        }

        return tree.evaluate();
    }


    private enum Operator {
        Mul(-1), Div(-2), Sum(-3), Sub(-4);

        private final int value;

        Operator(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Operator fromValue(int value) {
            for (Operator op : Operator.values()) {
                if (op.value == value) {
                    return op;
                }
            }
            return null;
        }

        public static int getPrecedence(int value) {
            if (value == Mul.value || value == Div.value) {
                return 2;
            }
            if (value == Sum.value || value == Sub.value) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown operator value");
        }
    }

    public static class ExpressionTree {
        private List<Integer> tokens = new ArrayList<>();

        public void add(int value) {
            tokens.add(value);
        }

        private int evaluatePostfix(List<Integer> postfix) {
            Stack<ExpressionNode> stack = new Stack<>();
            for (int token : postfix) {
                if (token >= 0) {
                    stack.push(new ExpressionNode(token));
                } else {
                    ExpressionNode rightNode = stack.pop();
                    ExpressionNode leftNode = stack.pop();
                    ExpressionNode operatorNode = new ExpressionNode(token);
                    operatorNode.left = leftNode;
                    operatorNode.right = rightNode;
                    stack.push(operatorNode);
                }
            }

            return stack.pop().evaluate();
        }

        private List<Integer> convertToPostfix(List<Integer> infixTokens) {
            List<Integer> postfix = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for (int token : infixTokens) {
                if (token >= 0) { // number
                    postfix.add(token);
                } else { // operator
                    while (!stack.isEmpty() && Operator.getPrecedence(stack.peek()) >= Operator.getPrecedence(token)) {
                        postfix.add(stack.pop());
                    }
                    stack.push(token);
                }
            }

            while (!stack.isEmpty()) {
                postfix.add(stack.pop());
            }

            return postfix;
        }

        public int evaluate() {
            List<Integer> postfix = convertToPostfix(tokens);
            return evaluatePostfix(postfix);
        }

    }

    private static class ExpressionNode {
        int value;
        ExpressionNode left, right;

        ExpressionNode(int value) {
            this.value = value;
        }

        boolean isOperator() {
            return value < 0;
        }

        int evaluate() {
            if (!isOperator()) {
                return value;
            }

            int leftValue = left == null ? 0 : left.evaluate();
            int rightValue = right == null ? 0 : right.evaluate();

            switch (Operator.fromValue(value)) {
                case Mul:
                    return leftValue * rightValue;
                case Div:
                    if (rightValue == 0) throw new ArithmeticException("Division by zero");
                    return leftValue / rightValue;
                case Sum:
                    return leftValue + rightValue;
                case Sub:
                    return leftValue - rightValue;
                default:
                    throw new IllegalStateException("Invalid operator");
            }
        }
    }
}
