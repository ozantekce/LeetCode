package Path_with_Maximum_Probability_1514;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.2}, 0, 2));
    }


    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        if(start_node == end_node)
            return 1;

        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int [] edge = edges[i];
            int first = edge[0];
            int second = edge[1];
            double prob = succProb[i];

            Node firstNode;
            if(nodeMap.containsKey(first)){
                firstNode = nodeMap.get(first);
            }else{
                firstNode = new Node();
                nodeMap.put(first, firstNode);
            }

            Node secondNode;
            if(nodeMap.containsKey(second)){
                secondNode = nodeMap.get(second);
            }else{
                secondNode = new Node();
                nodeMap.put(second, secondNode);
            }

            firstNode.edges.add(new Edge(secondNode, prob));
            secondNode.edges.add(new Edge(firstNode, prob));
        }

        if(!nodeMap.containsKey(end_node) || !nodeMap.containsKey(start_node))
            return 0;

        nodeMap.get(start_node).prob = 1;

        Queue<Node> frontier = new ArrayDeque<>();
        frontier.add(nodeMap.get(start_node));

        while (!frontier.isEmpty()){
            Node current = frontier.poll();
            List<Edge> edgeList = current.edges;
            for (Edge edge : edgeList) {
                Node to = edge.to;
                double value = current.prob * edge.prob;
                if (value > to.prob) {
                    to.prob = value;
                    frontier.add(to);
                }
            }

        }

        return nodeMap.get(end_node).prob;
    }

    
    private static  class Node{
        double prob;
        List<Edge> edges;
        public Node(){
            this.edges = new ArrayList<>();
        }
    }
    
    private static class Edge {
        Node to;
        double prob;
        public Edge(Node to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }
    
}
