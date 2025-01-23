package Map_of_Highest_Peak_1765;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int [][] isWater = {{0,0,1},{1,0,0},{0,0,0}};

        int [][] heights = highestPeak(isWater);



    }


    public static int[][] highestPeak(int[][] isWater) {

        int[][] heights = new int[isWater.length][isWater[0].length];
        Queue<int[]> frontier = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                heights[i][j] = -1;
                if(isWater[i][j]==1){
                    heights[i][j] = 0;
                    frontier.add(new int[]{i,j});
                }
            }
        }

        while (!frontier.isEmpty()){
            int[] current = frontier.poll();
            int currentHeight = heights[current[0]][current[1]];
            int upI = current[0]-1, upJ = current[1];
            int downI = current[0]+1, downJ = current[1];
            int leftI = current[0], leftJ = current[1]-1;
            int rightI = current[0] ,rightJ = current[1]+1;

            if(upI>=0){
                if(heights[upI][upJ]==-1){
                    heights[upI][upJ] = currentHeight+1;
                    frontier.add(new int[]{upI,upJ});
                }
            }
            if(downI<heights.length){
                if(heights[downI][downJ]==-1){
                    heights[downI][downJ] = currentHeight+1;
                    frontier.add(new int[]{downI,downJ});
                }
            }
            if(leftJ>=0){
                if(heights[leftI][leftJ]==-1){
                    heights[leftI][leftJ] = currentHeight+1;
                    frontier.add(new int[]{leftI,leftJ});
                }
            }
            if(rightJ<heights[0].length){
                if(heights[rightI][rightJ]==-1){
                    heights[rightI][rightJ] = currentHeight+1;
                    frontier.add(new int[]{rightI,rightJ});
                }
            }

        }

        return heights;
    }

}
