package Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One_1404;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(numSteps("1101"));
        //System.out.println(numSteps("11001"));
        System.out.println(numSteps("10"));
        //System.out.println(numSteps("1"));

    }


    public static int numSteps(String s) {

        int size = s.length() - 1;
        int carry = 0;
        int steps = 0;

        for (int i = size; i >= 0; i--) {
            int current = (s.charAt(i) - '0') + carry;
            carry = 0;

            if(current == 2){
                carry = 1;
            }
            else if(current == 1){
                if(i == 0)
                    break;
                carry = 1;
                steps++;
            }

            steps++;

        }

        return steps;
    }


    public static int numStepsLinkedList(String s) {

        Node head, tail;
        Node newNode = new Node(s.charAt(0), null);
        head = tail = newNode;
        for (int i = 1; i < s.length(); i++) {
            newNode = new Node(s.charAt(i), tail);
            tail = newNode;
        }

        int steps = 0;
        while (head != tail || head.data != '1') {

            if (tail.data == '0') {
                // Remove the last node
                tail = tail.prev;
            } else {
                int carry = 1;
                Node node = tail;
                while (node != null && carry == 1) {
                    int current = node.data - '0';
                    int sum = carry + current;
                    if (sum == 2) {
                        node.data = '0';
                    } else {
                        node.data = '1';
                        carry = 0;
                    }
                    node = node.prev;
                }

                if (carry == 1) {
                    Node newHead = new Node('1', null);
                    head.prev = newHead;
                    head = newHead;
                }
            }
            steps++;
        }

        return steps;
    }

    private static class Node {
        private char data;
        private Node prev;

        public Node(char data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }


}
