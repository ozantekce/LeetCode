package Minimum_Height_Trees_310;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));

    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges){

        if(edges.length == 0){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }

        int [][] normalizedEdges = new int[n][];
        int [][] memory = new int[n][];

        int [] edgeSizes = new int[n];
        // count sizes
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            edgeSizes[first]++;
            edgeSizes[second]++;
        }

        for (int i = 0; i < n; i++) {
            normalizedEdges[i] = new int[edgeSizes[i]];
            memory[i] = new int[edgeSizes[i]];
        }

        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];

            normalizedEdges[first][--edgeSizes[first]] = second;
            normalizedEdges[second][--edgeSizes[second]] = first;
        }

        int min = Integer.MAX_VALUE;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            if(normalizedEdges[i].length >= 2){
                heights[i] = height(i, -1, normalizedEdges, memory);
                min = Math.min(min, heights[i]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] == min){
                res.add(i);
            }
        }

        if(res.size() == 0){
            res.add(edges[0][0]);
            res.add(edges[0][1]);
        }

        return res;
    }

    public static int height(int i, int p, int[][] normalizedEdges, int[][] memory){

        int max = 0;
        int [] edges = normalizedEdges[i];
        for (int j = 0; j < edges.length; j++) {
            int child = edges[j];
            if(child != p){
                int val = memory[i][j];
                if (val == 0){
                    val = height(child, i, normalizedEdges, memory) + 1;
                    memory[i][j] = val;
                }
                max = Math.max(max, val);
            }
        }

        return max;
    }



    public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        int [] edgeSizes = new int[n];
        // count sizes
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            edgeSizes[first]++;
            edgeSizes[second]++;
        }

        Node[] nodes = new Node[n];
        // create nodes
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, edgeSizes[i]);
        }

        // add next nodes
        for (int i = 0; i < edges.length; i++) {
            Node first = nodes[edges[i][0]];
            Node second = nodes[edges[i][1]];

            first.add(second);
            second.add(first);
        }

        int min = Integer.MAX_VALUE;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = nodes[i].height();
            min = Math.min(min, heights[i]);
        }
        //System.out.println(Arrays.toString(heights));

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] == min){
                res.add(i);
            }
        }


        return res;
    }


    private static class Node{

        private int value;
        private int size;
        private Node[] nexts;
        private int [] memory;

        public Node(int value, int size){
            this.value = value;
            nexts = new Node[size];
            memory = new int[size];
        }

        public void add(Node node){
            nexts[size++] = node;
        }

        public int height(){
            return findHeight(null);
        }

        private int findHeight(Node parent){
            int max = 0;
            for (int i = 0; i < nexts.length; i++) {
                Node child = nexts[i];
                if(child == parent){
                    continue;
                }
                int temp;
                if(memory[i] != 0){
                    temp = memory[i];
                }else{
                    temp = memory[i] = child.findHeight(this);
                }
                max = Math.max(max, temp);
            }
            return max + 1;
        }

    }
}
