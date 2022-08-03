package Ugly_Number_II_264;

import java.util.*;

public class Solution {

    // Tree Solution
    public static void main(String[] args) {

        long s;
        long f;
        System.out.println("-------------------------");
        s = System.currentTimeMillis();
        System.out.println(nthUglyNumber(1600));
        f = System.currentTimeMillis();
        System.out.println("time : "+(f-s));
    }

    public static int nthUglyNumber(int n) {

        MyTree tree = new MyTree();
        long values [] = new long[n+1];
        values[1] = 1;
        tree.root = new Node(1,1);
        tree.root.child2 = new Node(tree.root.value,2);
        tree.root.child3 = new Node(tree.root.value,3);
        tree.root.child5 = new Node(tree.root.value,5);

        tree.leaves.add(tree.root.child2);
        tree.leaves.add(tree.root.child3);
        tree.leaves.add(tree.root.child5);

        for (int i = 2; i <= n; i++) {
            Node minLeaf = tree.getMinLeaf();

            values[i] = minLeaf.value;

            if(minLeaf.prime==2)
                minLeaf.child2 = new Node(minLeaf.value,2);
            if(minLeaf.prime==2 || minLeaf.prime==3)
                minLeaf.child3 = new Node(minLeaf.value,3);
            if(minLeaf.prime==2 || minLeaf.prime==3 || minLeaf.prime ==5)
                minLeaf.child5 = new Node(minLeaf.value,5);

            if(minLeaf.child2!=null)
                tree.leaves.add(minLeaf.child2);
            if(minLeaf.child3!=null)
                tree.leaves.add(minLeaf.child3);
            if(minLeaf.child5!=null)
                tree.leaves.add(minLeaf.child5);

        }
        return (int) values[n];
    }

    private static class MyTree{

        Node root;
        TreeSet<Node> leaves = new TreeSet<>();
        public Node getMinLeaf(){
            return leaves.pollFirst();
        }

    }

    private static class Node implements Comparable<Node>{

        long value;
        long prime;
        Node child2;
        Node child3;
        Node child5;

        public Node(long parentValue,long prime) {
            this.prime = prime;
            this.value = parentValue*prime;
        }

        @Override
        public int compareTo(Node node) {
            if(this.value>node.value)
                return 1;
            else if(this.value< node.value)
                return -1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", prime=" + prime +
                    '}';
        }
    }

}
