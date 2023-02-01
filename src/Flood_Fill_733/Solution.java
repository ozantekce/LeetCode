package Flood_Fill_733;
public class Solution {



    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(color == image[sr][sc])
            return image;
        recursive(image,sr,sc,image[sr][sc],color);

        return image;
    }



    public void recursive(int[][] image, int i, int j, int target, int newColor){

        int upI = i+1;
        int downI = i-1;
        int leftJ = j-1;
        int rightJ = j+1;

        image[i][j] = newColor;

        if(upI<image.length && image[upI][j] == target){
            recursive(image,upI,j,target,newColor);
        }
        if(downI>=0 && image[downI][j] == target){
            recursive(image,downI,j,target,newColor);
        }
        if(leftJ>=0 && image[i][leftJ] == target){
            recursive(image,i,leftJ,target,newColor);
        }
        if(rightJ<image[0].length && image[i][rightJ] == target){
            recursive(image,i,rightJ,target,newColor);
        }

    }


}
