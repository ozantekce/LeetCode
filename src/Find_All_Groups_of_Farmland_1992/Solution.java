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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Int2 pos = new Int2(i, j);
                if(land[i][j] == 1 ){
                    Area area = new Area(n, m);
                    Queue<Int2> frotier = new ArrayDeque<>();
                    frotier.add(pos);

                    while (!frotier.isEmpty()){
                        Int2 current = frotier.poll();
                        if(land[current.i][current.j] == 0)
                            continue;
                        area.add(current);
                        land[current.i][current.j] = 0;
                        Int2 right = getNeighborIndices(current, Direction.Right);
                        Int2 down = getNeighborIndices(current, Direction.Down);
                        if(isValidIndices(right, n, m) && land[right.i][right.j] == 1){
                            frotier.add(right);
                        }
                        if(isValidIndices(down, n, m) && land[down.i][down.j] == 1){
                            frotier.add(down);
                        }
                    }
                    list.add(area.convertArray());
                }

            }
        }

        int[][] res = new int[list.size()][4];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
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
        return !(indices.i<0 || indices.j<0 || indices.i>=n || indices.j>=m);
    }


    private static class Area{

        private Int2 leftCorner;
        private Int2 rightCorner;

        public Area(int n, int m){
            this.leftCorner = new Int2(n, m);
            this.rightCorner = new Int2(0, 0);
        }

        public void add(Int2 val){
            if(val.i < leftCorner.i && val.j <= leftCorner.j){
                leftCorner = val;
            }else if(val.i <= leftCorner.i && val.j < leftCorner.j){
                leftCorner = val;
            }

            if(val.i > rightCorner.i && val.j >= rightCorner.j){
                rightCorner = val;
            }else if(val.i >= rightCorner.i && val.j > rightCorner.j){
                rightCorner = val;
            }
        }

        public int[] convertArray(){
            int[] array = new int[4];
            array[0] = leftCorner.i;
            array[1] = leftCorner.j;
            array[2] = rightCorner.i;
            array[3] = rightCorner.j;
            return array;
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
