package Minimum_Height_Trees_310;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
        System.out.println(findMinHeightTrees(2, new int[][]{{0,1}}));

    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges){

        List<Integer> res = new ArrayList<>(2);

        if(edges.length == 0){
            res.add(0);
            return res;
        }else if (edges.length == 1){
            res.add(edges[0][0]);
            res.add(edges[0][1]);
            return res;
        }

        int [][] normalizedEdges = new int[n][];
        int [][] memory = new int[n][];

        int [] edgeSizes = new int[n];
        // count edge sizes
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            edgeSizes[first]++;
            edgeSizes[second]++;
        }

        // create arrays
        for (int i = 0; i < n; i++) {
            normalizedEdges[i] = new int[edgeSizes[i]];
            memory[i] = new int[edgeSizes[i]];
        }

        // fill arrays
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];

            normalizedEdges[first][--edgeSizes[first]] = second;
            normalizedEdges[second][--edgeSizes[second]] = first;
        }

        // find heights
        int min = Integer.MAX_VALUE;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            if(normalizedEdges[i].length >= 2){
                heights[i] = height(i, -1, normalizedEdges, memory);
                min = Math.min(min, heights[i]);
            }
        }


        for (int i = 0; i < heights.length; i++) {
            if(heights[i] == min){
                res.add(i);
            }
        }

        return res;
    }


    // H(r, p, es) = Max(H(es[r][0],r,es),H(es[r][1],r,edges)...,H(es[r][p-1],r,edges), H(es[r][p+1],r,edges...)) + 1
    public static int height(int root, int parent, int[][] normalizedEdges, int[][] memory){

        int max = 0;
        int [] edges = normalizedEdges[root];
        for (int j = 0; j < edges.length; j++) {
            int child = edges[j];
            if(child != parent){
                int val = memory[root][j];
                if (val == 0){
                    memory[root][j] = val = height(child, root, normalizedEdges, memory) + 1;
                }
                max = Math.max(max, val);
            }
        }

        return max;
    }

}
