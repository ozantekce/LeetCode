package Container_With_Most_Water_11;

public class Solution {

    public static void main(String[] args) {

        int height [] ={1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));

    }

    public static int maxArea(int[] height) {

        int p1 = 0;
        int p2 = height.length-1;
        int maxWater = 0;
        int length = p2;
        while (p1<p2){
            if(height[p1]<height[p2]){
                maxWater = Math.max(maxWater,(length*height[p1]));
                p1++;
            }else{
                maxWater = Math.max(maxWater,(length*height[p2]));
                p2--;
            }
            length--;
        }

        return maxWater;
    }

}
