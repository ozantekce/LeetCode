package Minimum_Number_of_Days_to_Eat_N_Oranges_1553;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(minDays(10));
        //System.out.println(minDays(6));
        System.out.println(minDays(84806671));

    }

    public static int minDays(int n) {

        Node root = new Node(0,n);

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Set<Integer> set = new HashSet<>();

        Node current;
        while (true){

            current = queue.poll();
            if(set.contains(current.value))
                continue;

            if(current.value==0){
                return current.day;
            }

            set.add(current.value);

            boolean op2 = current.value % 2 == 0;
            boolean op3 = current.value % 3 == 0;

            queue.add(new Node(current.day+1, current.value-1));

            if(op3){
                queue.add(new Node(current.day+1, current.value/3));
            }
            if(op2){
                queue.add(new Node(current.day+1, current.value/2));
            }

        }

    }


    private static class Node{

        private int day;
        private int value;

        public Node(int day, int value) {
            this.day = day;
            this.value = value;
        }
    }

}
