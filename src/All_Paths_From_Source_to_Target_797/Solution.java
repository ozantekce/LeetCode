package All_Paths_From_Source_to_Target_797;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        out = new ArrayList<>();
        recursive(0, graph, null);
        return out;
    }


    public static List<List<Integer>> out = new ArrayList<>();

    public static List recursive(int node,int graph[][],int ... args){

        int tempArray[];

        if(args!=null){
            tempArray = new int[args.length+1];
            System.arraycopy(args, 0, tempArray, 0, args.length);
            tempArray[args.length] = node;
        }
        else{
            tempArray = new int[1];
            tempArray[0] = node;
        }


        if(node == graph.length-1){
            List<Integer> list = new ArrayList<>();
            for(int data:tempArray) {
                list.add(data);
            }

            return list;
        }



        for (int i = 0; i < graph[node].length; i++) {
            if(graph[node][i]==0)continue;

            List temp = recursive(graph[node][i], graph, tempArray);

            if(temp!=null){
                out.add(temp);
            }


        }

        return null;

    }

}
