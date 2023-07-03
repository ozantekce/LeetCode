package Node_With_Highest_Edge_Score_2374;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {

        System.out.println(edgeScore(new int[]{1,0,0,0,0,7,7,5}));
        System.out.println(edgeScore(new int[]{2,0,0,2}));

    }


    public static int edgeScore(int[] edges) {
        long [] map = new long[edges.length];
        long maxScore = -1;
        int maxNode = -1;

        for (int i = 0; i < edges.length; i++) {
            map[edges[i]] += i;
            if(map[edges[i]] > maxScore){
                maxScore = map[edges[i]];
                maxNode = edges[i];
            }
            else if(map[edges[i]] == maxScore){
                if(edges[i] < maxNode){
                    maxNode = edges[i];
                }
            }
        }
        return maxNode;
    }


}
