package Find_Eventual_Safe_States_802;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        System.out.println(eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
        //System.out.println(eventualSafeNodes(new int[][]{{0}, {2, 3, 4}, {3, 4}, {0, 4}, {}}));
        //System.out.println(eventualSafeNodes(new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}}));

    }


    public static List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        boolean[] recursion = new boolean[graph.length];
        boolean[] cycle = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isCyclic(i, graph, visited, recursion, cycle)) {
                result.add(i);
            }
        }

        return result;
    }


    public static boolean isCyclic(int i,
                                   int[][] graph,
                                   boolean[] visited,
                                   boolean[] recursion,
                                   boolean[] cycle) {

        if (cycle[i])
            return true;

        if (recursion[i])
            return true;

        if (visited[i])
            return false;

        recursion[i] = true;
        visited[i] = true;

        for (int j = 0; j < graph[i].length; j++) {
            int next = graph[i][j];
            if (isCyclic(next, graph, visited, recursion, cycle)) {
                cycle[i] = true;
                recursion[i] = false;
                return true;
            }
        }

        recursion[i] = false;
        return false;
    }


}
