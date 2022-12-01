package Map_of_Highest_Peak_1765;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int [][] isWater = {{0,0,1},{1,0,0},{0,0,0}};

        int [][] heights = highestPeak(isWater);



    }


    public static int[][] highestPeak(int[][] isWater) {

        int[][] heights = new int[isWater.length][isWater[0].length];
        List<Pair> heightsN = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                heights[i][j] = -1;
                if(isWater[i][j]==1){
                    heights[i][j] = 0;
                    heightsN.add(new Pair(i,j));
                }
            }
        }

        int currentHeight = 0;
        List<Pair> nextHeights = new ArrayList<>();
        while (true){

            nextHeights.clear();
            for (int i = 0; i < heightsN.size(); i++) {
                Pair current = heightsN.get(i);
                int upI = current.i-1, upJ = current.j;
                int downI = current.i+1, downJ = current.j;
                int leftI = current.i, leftJ = current.j-1;
                int rightI = current.i ,rightJ = current.j+1;

                if(upI>=0){
                    if(heights[upI][upJ]==-1){
                        heights[upI][upJ] = currentHeight+1;
                        nextHeights.add(new Pair(upI,upJ));
                    }
                }
                if(downI<heights.length){
                    if(heights[downI][downJ]==-1){
                        heights[downI][downJ] = currentHeight+1;
                        nextHeights.add(new Pair(downI,downJ));
                    }
                }
                if(leftJ>=0){
                    if(heights[leftI][leftJ]==-1){
                        heights[leftI][leftJ] = currentHeight+1;
                        nextHeights.add(new Pair(leftI,leftJ));
                    }
                }
                if(rightJ<heights[0].length){
                    if(heights[rightI][rightJ]==-1){
                        heights[rightI][rightJ] = currentHeight+1;
                        nextHeights.add(new Pair(rightI,rightJ));
                    }
                }

            }
            currentHeight++;
            heightsN = new ArrayList<>(nextHeights);
/*

            System.out.println("--------------------------------------");
            for (int i = 0; i < heights.length; i++) {
                System.out.println(Arrays.toString(heights[i]));
            }
*/
            if(heightsN.size()==0){
                break;
            }

        }

        return heights;
    }



    public static class Pair{

        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

}
