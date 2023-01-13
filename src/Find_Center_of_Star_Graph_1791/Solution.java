package Find_Center_of_Star_Graph_1791;

public class Solution {


    public static int findCenter(int[][] edges) {


        int r1 = edges[0][0];
        int r2 = edges[0][1];
        int v1 = edges[1][0];
        int v2 = edges[1][1];
        int center;
        if(r1==v1 || r1==v2){
            center = r1;
        }else{
            center = r2;
        }

        return center;
    }

}
