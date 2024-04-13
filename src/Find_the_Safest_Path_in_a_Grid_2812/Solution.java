package Find_the_Safest_Path_in_a_Grid_2812;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {

        List<List<Integer>> arrayList = Stream.of(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 1}})
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList())).toList();

        System.out.println(maximumSafenessFactor(arrayList)+" | 0");

        arrayList = Stream.of(new int[][]{{0, 0, 1}, {0, 0, 0}, {0, 0, 0}})
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList())).toList();

        System.out.println(maximumSafenessFactor(arrayList)+" | 2");

        arrayList = Stream.of(new int[][]{{0,0,0,1}, {0,0,0,0}, {0,0,0,0}, {1,0,0,0}})
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList())).toList();

        System.out.println(maximumSafenessFactor(arrayList)+" | 2");

        arrayList = Stream.of(new int[][]{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0},
                {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0},
                                        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,0},
                                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0},
                                                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
                                                                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
                                                                    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                                                                            {0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                                                                                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                                                                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                                                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                                                                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                                                                                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                                                                                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                                                                                                        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0}})
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList())).toList();

        System.out.println(maximumSafenessFactor(arrayList)+" | 2");

    }


    private static int[][] Directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // right, left, up, down

    public static int maximumSafenessFactor(List<List<Integer>> grid) {

        if(grid.get(0).get(0) == 1)
            return 0;

        int n = grid.size();

        Queue<Int2> bfs = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1){
                    Int2 pos = new Int2(i, j, 0);
                    grid.get(i).set(j, 0);
                    bfs.add(pos);
                }else{
                    grid.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }

        boolean[][] visited = new boolean[n][n];
        while (!bfs.isEmpty()){
            Int2 pos = bfs.poll();

            int val = Math.min(grid.get(pos.i).get(pos.j), pos.parentValue);
            grid.get(pos.i).set(pos.j, val);

            for (int[] dir : Directions) {
                int ni = pos.i + dir[0];
                int nj = pos.j + dir[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    bfs.add(new Int2(ni, nj, pos.parentValue + 1));
                }
            }

        }


        int maxV = grid.get(n - 1).get(n - 1);
        int minV = 1;
        int record = -1;
        Int2 start = new Int2(0, 0);
        while (minV <= maxV) {
            int v = minV + (maxV - minV) / 2;
            //System.out.println("v: "+v);
            int res = BFS(start, grid, v);
            if (res != -1) {
                record = res;
                minV = v + 1;
            } else {
                maxV = v - 1;
            }
        }
        return record == -1 ? 0 : record;

    }


    private static int BFS(Int2 start, List<List<Integer>> grid, int skip) {
        int n = grid.size();
        Queue<Int2> queue = new ArrayDeque<>();
        queue.add(start);

        boolean[][] visited = new boolean[n][n];
        visited[start.i][start.j] = true;



        int res = -1;
        while (!queue.isEmpty()) {
            Int2 pos = queue.poll();
            int selfValue = Math.min(grid.get(pos.i).get(pos.j), (pos.parentValue != null ? pos.parentValue : Integer.MAX_VALUE));

            if (pos.i == n-1 && pos.j == n-1) {
                res = Math.max(selfValue, res);
                break;
            }

            for (int[] dir : Directions) {
                int ni = pos.i + dir[0];
                int nj = pos.j + dir[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj] && grid.get(ni).get(nj) >= skip) {
                    visited[ni][nj] = true;
                    queue.add(new Int2(ni, nj, selfValue));
                }
            }

        }
        return res;
    }


    private static class Int2{
        int i, j;
        Integer parentValue;

        public Int2(int i, int j) {
            this.i = i;
            this.j = j;
        }

        Int2(int i, int j, Integer parentValue) {
            this(i, j);
            this.parentValue = parentValue;
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
            return Objects.hash(i, j);
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
