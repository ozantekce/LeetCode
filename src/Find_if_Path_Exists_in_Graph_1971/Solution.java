package Find_if_Path_Exists_in_Graph_1971;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        System.out.println(validPath(3, new int[][]{{0,1},{0,1},{2,0}},0,2));
    }


    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination)
            return true;

        boolean[] visited = new boolean[n];

        visited[source] = true;

        while (true){
            boolean cannotFound = true;
            for (int i = 0; i < edges.length; i++) {

                int[] edge = edges[i];
                int s = edge[0];
                int d = edge[1];

                if(visited[s] && !visited[d]){
                    visited[d] = true;
                    cannotFound = false;
                    if(d == destination)
                        return true;
                }
                if(visited[d] && !visited[s]){
                    visited[s] = true;
                    cannotFound = false;
                    if(s == destination)
                        return true;
                }

            }

            if(cannotFound){
                return false;
            }

        }

    }


}
