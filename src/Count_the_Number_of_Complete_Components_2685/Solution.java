package Count_the_Number_of_Complete_Components_2685;


import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(countCompleteComponents(6, new int[][]{{1, 2}, {0, 2}, {3, 4}}));
        //System.out.println(countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}}));
        //System.out.println(countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}}));
        //System.out.println(countCompleteComponents(5, new int[][]{{2, 1}, {3, 0}, {4, 2}, {4, 3}}));
        System.out.println(countCompleteComponents(3, new int[][]{{2, 1}}));
        //System.out.println(countCompleteComponents(9, new int[][]{{8, 6}, {5, 8}, {1, 6}, {0, 8}, {3, 4}, {7, 3}, {2, 4}}));
        //System.out.println(countCompleteComponents(10, new int[][]{{7, 4}, {1, 7}, {0, 4}, {1, 0}, {5, 2}, {6, 2}, {8, 9}, {3, 9}}));
    }


    public static int countCompleteComponents(int n, int[][] edges) {
        int graphCount = 0;
        Graph[] nodeToGraph = new Graph[n];
        for (int i = 0; i < edges.length; i++) {
            int n0 = edges[i][0];
            int n1 = edges[i][1];
            Graph g0 = nodeToGraph[n0];
            Graph g1 = nodeToGraph[n1];
            if (g0 != null && g1 != null) {
                if (g0.i < g1.i) g1.next = g0;
                else if (g0.i > g1.i) g0.next = g1;
            } else if (g0 != null) {
                nodeToGraph[n1] = nodeToGraph[n0];
            } else if (g1 != null) {
                nodeToGraph[n0] = nodeToGraph[n1];
            } else {
                nodeToGraph[n0] = nodeToGraph[n1] = new Graph(graphCount++);
            }
        }

        int[] nodeToGraphIndex = new int[n];
        for (int i = 0; i < n; i++) {
            nodeToGraphIndex[i] = nodeToGraph[i] != null ? nodeToGraph[i].value() : graphCount++;
        }

        int[] subGraphNodeCount = new int[n];
        for (int i = 0; i < n; i++) {
            subGraphNodeCount[nodeToGraphIndex[i]]++;
        }

        int[] subGraphEdgeCount = new int[n];
        for (int i = 0; i < edges.length; i++) {
            subGraphEdgeCount[nodeToGraphIndex[edges[i][0]]]++;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int m = subGraphNodeCount[i];
            int e = subGraphEdgeCount[i];
            if (m == 0) continue;
            boolean isCompleteComponent = (m * (m - 1) / 2) == e;
            if (isCompleteComponent) res++;
        }

        return res;
    }

    private static class Graph {
        public int i;
        public Graph next;
        public Graph(int i) {
            this.i = i;
        }
        public int value() {
            return next == null ? i : next.i;
        }
    }

}
