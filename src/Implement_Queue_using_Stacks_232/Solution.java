package Implement_Queue_using_Stacks_232;

import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

    }


    private static class MyQueue {

        private Stack<Integer> stack0;
        private Stack<Integer> stack1;

        public MyQueue() {
            stack0 = new Stack<>();
            stack1 = new Stack<>();
        }

        public void push(int x) {

            while (!stack1.isEmpty()){
                stack0.add(stack1.pop());
            }
            stack1.push(x);
            while (!stack0.isEmpty()){
                stack1.add(stack0.pop());
            }

        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty();
        }

    }


}
