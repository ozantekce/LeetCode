package Sum_of_Distances_in_Tree_834;

import java.util.*;


public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
    }




    public static int[] sumOfDistancesInTree(int n, int[][] edges){

        int [] res = new int[n];
        HashMap<Int2, int[]> subTrees = new HashMap<>();

        int[][] normalizedEdges = new int[n][];
        int[] edgeSizes = new int[n];

        for (int[] edge : edges) {
            edgeSizes[edge[0]]++;
            edgeSizes[edge[1]]++;
        }

        for (int i = 0; i < n; i++) {
            normalizedEdges[i] = new int[edgeSizes[i]];
        }

        Arrays.fill(edgeSizes, 0);

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];

            normalizedEdges[first][edgeSizes[first]++] = second;
            normalizedEdges[second][edgeSizes[second]++] = first;
        }


        for (int i = 0; i < n; i++) {
            res[i] = tree(i, subTrees, normalizedEdges);
        }

/*
        for (var p: subTrees.entrySet()) {
            System.out.println(p.getKey()+" -> " + Arrays.toString(p.getValue()));
        }
*/
        return res;
    }


    private static int tree(int root, HashMap<Int2, int[]> subTrees, int[][] normalizedEdges) {

        int[] children = normalizedEdges[root];
        int value = 0;


        for (int subRoot : children) {
            Int2 subTree = new Int2(root, subRoot);
            int[] subTreeFields = subTrees.getOrDefault(subTree, null);

            if (subTreeFields == null) {
                subTreeFields = subTree(root, subRoot, normalizedEdges, subTrees);
                subTrees.put(subTree, subTreeFields);
            }


            value += subTreeFields[0] + subTreeFields[1];
        }


        return value;
    }


    private static int[] subTree(int mainRoot, int subRoot, int[][] normalizedEdges, HashMap<Int2, int[]> subTrees) {
        int value = 0;
        int size = 1;

        Int2 subtree = new Int2(mainRoot, subRoot);
        Int2 temp;
        if (subTrees.containsKey(subtree)) {
            return subTrees.get(subtree);
        }else if(normalizedEdges[mainRoot].length == 1 && subTrees.containsKey(temp = new Int2(-1, subRoot))){
            return subTrees.get(temp);
        }

        for (int i = 0; i < normalizedEdges[subRoot].length; i++) {
            int child = normalizedEdges[subRoot][i];
            if (child != mainRoot) {
                int[] childResult = subTree(subRoot, child, normalizedEdges, subTrees);
                size += childResult[0];
                value += childResult[1] + childResult[0];
            }
        }
        int[] res = new int[]{size, value};

        subTrees.put(subtree, res);
        if(normalizedEdges[mainRoot].length == 1){
            temp = new Int2(-1, subRoot);
            subTrees.put(temp, res);
        }
        return res;
    }


    private static class Int2{
        int i, j;

        public Int2(int i, int j) {
            this.i = i;
            this.j = j;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Int2 int2 = (Int2) o;
            return i == int2.i && j == int2.j;
        }

        @Override
        public int hashCode() {
            return i+j;
        }

        @Override
        public String toString() {
            return "Int2{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }



}
