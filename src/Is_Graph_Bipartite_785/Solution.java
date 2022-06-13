package Is_Graph_Bipartite_785;

public class Solution {

    public static boolean isBipartite(int[][] graph) {


        int nodes [] = new int[graph.length];
        nodes[0] = 1;

        boolean reStart = false;
        int temp = 0;

        for (int i = 0; i < graph.length; i++) {

            for (int j = 0; j < graph[i].length; j++) {
                int node1 = i;
                int node2 = graph[i][j];

                if(nodes[node1]==0){

                    if(nodes[node2]==0){

                        if(!reStart){
                            reStart=true;
                            temp = node1;
                        }

                    }
                    else if(nodes[node2]==1){

                        nodes[node1]=2;

                    }
                    else{

                        nodes[node1]=1;

                    }

                }
                else if(nodes[node1]==1){

                    if(nodes[node2]==0){

                        nodes[node2] = 2;

                    }
                    else if(nodes[node2]==1){

                        return false;

                    }


                }
                else{

                    if(nodes[node2]==0){

                        nodes[node2] = 1;

                    }
                    else if(nodes[node2]==2){

                        return false;

                    }

                }


            }

            if(reStart&& i == graph.length-1){
                i=temp-1;
                reStart=false;
                if(nodes[temp]==0){
                    nodes[temp] = 1;
                }
            }

        }




        return true;
    }

}
