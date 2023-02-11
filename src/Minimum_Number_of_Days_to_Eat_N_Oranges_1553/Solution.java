package Minimum_Number_of_Days_to_Eat_N_Oranges_1553;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minDays(10));        // 4
        System.out.println(minDays(6));         // 3
        System.out.println(minDays(84806671));  // 32

    }

    public static int minDays(int n) {

        Node root = new Node(0,n);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(root);

        Set<Integer> set = new HashSet<>();

        Node current;
        while (true){

            current = queue.poll();
            if(set.contains(current.value))
                continue;

            if(current.value<2){
                return current.day + current.value;
            }

            set.add(current.value);

            int r2 = current.value % 2;
            int r3 = current.value % 3;

            queue.add(new Node(current.day+r3+1, current.value/3));
            queue.add(new Node(current.day+r2+1, current.value/2));

        }

    }


    private static class Node implements Comparable<Node>{

        private int day;
        private int value;

        public Node(int day, int value) {
            this.day = day;
            this.value = value;
        }


        @Override
        public int compareTo(Node o) {

            if(this.day>o.day)return 1;
            else if(this.day<o.day)return -1;
            else return 0;
        }
    }
}
