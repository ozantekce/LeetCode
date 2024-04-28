package Find_All_Groups_of_Farmland_1992;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,0,0}, {0,1,1}, {0,1,1}})));
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,1}, {1,1}})));
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,1}, {0,0}})));

    }

    private enum Direction{
        Left,
        Right,
        Up,
        Down,
    }

    public static int[][] findFarmland(int[][] land) {

        List<int[]> list = new ArrayList<>();

        int n = land.length;
        int m = land[0].length;

        Queue<Int2> frontier = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 0)
                    continue;

                Int2 startPos = new Int2(i, j);
                Area area = new Area(i, j, n, m);
                frontier.add(startPos);

                while (!frontier.isEmpty()){
                    Int2 current = frontier.poll();
                    if(land[current.i][current.j] == 0)
                        continue;
                    area.add(current);
                    land[current.i][current.j] = 0;
                    Int2 right = getNeighborIndices(current, Direction.Right);
                    Int2 down = getNeighborIndices(current, Direction.Down);
                    if(isValidIndices(right, n, m) && land[right.i][right.j] == 1){
                        frontier.add(right);
                    }
                    if(isValidIndices(down, n, m) && land[down.i][down.j] == 1){
                        frontier.add(down);
                    }
                }
                list.add(area.getCorners());

            }
        }

        return list.toArray(new int[list.size()][]);
    }

    private static Int2 getNeighborIndices(Int2 indices, Direction direction){
        if(direction == Direction.Right){
            return new Int2(indices.i, indices.j+1);
        }else if(direction == Direction.Down){
            return new Int2(indices.i+1, indices.j);
        }else if(direction == Direction.Left){
            return new Int2(indices.i , indices.j-1);
        }else{
            return new Int2(indices.i-1, indices.j);
        }
    }

    private static boolean isValidIndices(Int2 indices, int n, int m){
        return indices.i >= 0 && indices.j >= 0 && indices.i < n && indices.j < m;
    }


    private static class Area{

        private int[] corners;

        public Area(int n, int m){
            this.corners = new int[] {n, m, 0, 0};
        }

        public Area(int i, int j,int n, int m){
            this.corners = new int[] {i, j, i, j};
        }

        public void add(Int2 val) {
            if ((val.i > corners[2] && val.j >= corners[3]) || (val.i >= corners[2] && val.j > corners[3])) {
                corners[2] = val.i;
                corners[3] = val.j;
            }
        }

        public int[] getCorners() {
            return corners;
        }

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
