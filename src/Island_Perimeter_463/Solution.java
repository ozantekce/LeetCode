package Island_Perimeter_463;

public class Solution {

    public static void main(String[] args) {

    }

    public static int islandPerimeter(int[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1){
                    count+=4;
                    if(i-1 >= 0 && grid[i-1][j] == 1){
                        count--;
                    }
                    if(i+1 <= grid.length-1 && grid[i+1][j] == 1){
                        count--;
                    }
                    if(j-1 >= 0 && grid[i][j-1] == 1){
                        count--;
                    }
                    if(j+1 <= grid[0].length-1 && grid[i][j+1] == 1){
                        count--;
                    }
                }

            }

        }

        return count;
    }

}
