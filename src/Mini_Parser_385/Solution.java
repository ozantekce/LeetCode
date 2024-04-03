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

        char[] chars = s.toCharArray();
        int stackCapacity = 0;
        int listCount = 0;
        for (char c : chars) {
            if (c == '['){
                listCount++;
                stackCapacity = Math.max(listCount, stackCapacity);
            }else if(c == ']'){
                listCount--;
            }
        }

        NestedInteger[] stack = new NestedInteger[stackCapacity];
        int size = 0;
        int value = 0;
        boolean readingNum = false;
        int sign = 1;
        for (char c : chars) {
            if (c == '[') {
                stack[size++] = new NestedInteger();
            }
            else if (c == ',') {
                if (readingNum && size != 0) {
                    NestedInteger l = stack[size - 1];
                    NestedInteger n = new NestedInteger(sign * value);
                    if (!l.isInteger()) {
                        l.add(n);
                    } else {
                        stack[size++] = n;
                    }
                    value = 0;
                    readingNum = false;
                    sign = 1;
                }
            }
            else if (c == ']') {
                if (readingNum && size != 0) {
                    NestedInteger l = stack[size - 1];
                    NestedInteger n = new NestedInteger(sign * value);
                    if (!l.isInteger()) {
                        l.add(n);
                    } else {
                        stack[size++] = n;
                    }
                    value = 0;
                    readingNum = false;
                    sign = 1;
                }

                if (size >= 2) {
                    NestedInteger p0 = stack[--size];
                    NestedInteger p1 = stack[--size];
                    if (!p1.isInteger()) {
                        p1.add(p0);
                        stack[size++] = p1;
                    }
                    if(size == 0)
                        break;
                } else {
                    break;
                }

            }
            else if (c == '-') {
                sign = -1;
            }
            else {
                readingNum = true;
                value *= 10;
                value += (c - '0');
            }
        }

        NestedInteger result;
        if(size != 0)
            result = stack[--size];
        else
            result = new NestedInteger(sign * value);

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
