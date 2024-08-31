package Path_with_Maximum_Probability_1514;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxProbability(3, new int[][]{{0,1},{1,2},{0,2}}, new double[]{0.5,0.5,0.2}, 0, 2));
    }


    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        if(start_node == end_node)
            return 1;

        boolean [] settled = new boolean[n];
        double [] finalCosts = new double[n];
        finalCosts[start_node] = 1;

        List<List<Edge>> normalizedEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            normalizedEdges.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int [] edge = edges[i];
            int first = edge[0];
            int second = edge[1];
            double prob = succProb[i];
            normalizedEdges.get(first).add(new Edge(second, prob));
            normalizedEdges.get(second).add(new Edge(first, prob));
        }

        if(normalizedEdges.get(start_node).isEmpty() ||
                normalizedEdges.get(end_node).isEmpty())
            return 0;

        PriorityQueue<Edge> frontier = new PriorityQueue<>();
        frontier.add(new Edge(start_node, 1));

        while (!frontier.isEmpty()) {

            Edge oldEdge = frontier.remove();
            int from = oldEdge.to;
            if(from == end_node) return oldEdge.cost;
            if (settled[from]) continue;
            settled[from] = true;

            List<Edge> currentEdges = normalizedEdges.get(from);
            for (Edge edge : currentEdges) {
                if (settled[edge.to]) continue;
                double cost = finalCosts[from] * edge.cost;
                if (cost > finalCosts[edge.to]){
                    finalCosts[edge.to] = cost;
                    frontier.add(new Edge(edge.to, finalCosts[edge.to]));
                }
            }
        }

        return finalCosts[end_node];
    }



    private static class Edge implements Comparable<Edge>{
        int to;
        double cost;

        public Edge(int to, double cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(o.cost, this.cost);
        }
    }
    
}
