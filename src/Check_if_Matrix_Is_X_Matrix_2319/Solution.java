package Check_if_Matrix_Is_X_Matrix_2319;

public class Solution {




    public boolean checkXMatrix(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid.length; j++) {

                if(isDiagonal(i,j,grid.length-1)){
                    if(grid[i][j]==0){
                        return false;
                    }
                }else{
                    if(grid[i][j]!=0){
                        return false;
                    }
                }

            }

        }


        return true;
    }


    public boolean isDiagonal(int i,int j,int n){

        if(i==j){
            return true;
        }
        if(i+j==n){
            return true;
        }
        return false;
    }

}
