package Mini_Parser_385;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {

        System.out.println(deserialize("324"));
        System.out.println(deserialize("[123,[456,[789]]]"));
        System.out.println(deserialize("[[1,2],[3,4]]"));
        System.out.println(deserialize("-3"));

    }



    public static NestedInteger deserialize(String s) {

        Stack<NestedInteger> stack = new Stack<>();

        char[] chars = s.toCharArray();
        int value = 0;
        boolean readingNum = false;
        boolean isPositive = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '['){
                stack.push(new NestedInteger());
            }else if(c == ','){
                if(readingNum){
                    if(!stack.isEmpty()){
                        NestedInteger l = stack.peek();
                        if(!isPositive) value *= -1;
                        NestedInteger n = new NestedInteger(value);
                        if(!l.isInteger()){
                            l.add(n);
                        }else{
                            stack.push(n);
                        }
                        value = 0;
                        readingNum = false;
                        isPositive = true;
                    }
                }
            }else if(c == ']'){
                if(readingNum){
                    if(!stack.isEmpty()){
                        NestedInteger l = stack.peek();
                        if(!isPositive) value *= -1;
                        NestedInteger n = new NestedInteger(value);
                        if(!l.isInteger()){
                            l.add(n);
                        }else{
                            stack.push(n);
                        }
                        value = 0;
                        readingNum = false;
                        isPositive = true;
                    }
                }

                if(stack.size() >= 2){
                    NestedInteger p0 = stack.pop();
                    NestedInteger p1 = stack.pop();
                    if(!p1.isInteger()){
                        p1.add(p0);
                        stack.push(p1);
                    }else{
                        stack.push(p1);
                        stack.push(p0);
                    }
                }

            }else if(c == '-'){
                isPositive = false;
            }else{
                readingNum = true;
                value *= 10;
                value += (c - '0');
            }
        }

        NestedInteger result = null;
        if(!stack.isEmpty())
            result = stack.pop();
        else
            result = new NestedInteger(isPositive ? value : -value);

        return result;
    }



    private static class NestedInteger {

        // This will store either a single integer or a nested list
        private Integer value;
        private List<NestedInteger> list;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            this.list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        // Returns true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return value != null;
        }

        // Returns the single integer that this NestedInteger holds, if it holds a single integer
        // Returns null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return this.value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
            this.list = null;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(ni);
        }

        // Returns the nested list that this NestedInteger holds, if it holds a nested list
        // Returns an empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            if (list == null) {
                return new ArrayList<>();
            }
            return list;
        }

        @Override
        public String toString() {
            if (this.isInteger()) {
                return String.valueOf(this.value);
            } else {
                return "[" + list.stream()
                        .map(NestedInteger::toString)
                        .collect(Collectors.joining(",")) + "]";
            }
        }


    }




}
