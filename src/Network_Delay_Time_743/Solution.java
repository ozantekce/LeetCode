package Network_Delay_Time_743;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// So bad solution, must be change
public class Solution{
    public static int networkDelayTime(int[][] times, int n, int k) {


        List<Vertex> vertexs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            vertexs.add(new Vertex(i));
        }

        for (int i = 0; i < times.length; i++) {

            int s = times[i][0]-1;
            int t = times[i][1]-1;
            int time = times[i][2];

            vertexs.get(s).addEdge(vertexs.get(t), time);


        }



        int value = vertexs.get(k-1).sendSignal(vertexs,0);

        return value;
    }





    protected static class Vertex{


        private int id;

        private boolean signalReached = false;

        HashMap<Vertex,Integer> edges= new HashMap<>();

        public Vertex(int id) {
            this.id = id;
        }



        public void addEdge(Vertex v,int value){

            if(v==null)return;

            edges.put(v, value);


        }



        @Override
        public String toString() {
            return id+"";
        }

        private int cost=-1;

        public int sendSignal(List<Vertex> vertexs, int total){

            cost = total;
            this.signalReached=true;

            for (int i = 0; i < vertexs.size(); i++) {
                Vertex temp = vertexs.get(i);
                if(edges.containsKey(temp) ){

                    if(temp.signalReached){

                        if(total+edges.get(vertexs.get(i))< vertexs.get(i).cost){
                            int t = total+edges.get(vertexs.get(i));
                            vertexs.get(i).sendSignal(vertexs, t);
                        }
                    }
                    else
                        vertexs.get(i).sendSignal(vertexs,total+edges.get(temp));
                }
            }



            return getMaxCost(vertexs);

        }


        private int getMaxCost(List<Vertex> vertexs){

            int maxcost=-1;

            for (int i = 0; i < vertexs.size(); i++) {

                if(vertexs.get(i).cost==-1)
                    return -1;

                if(vertexs.get(i).cost>maxcost){
                    maxcost = vertexs.get(i).cost;
                }

            }

            return maxcost;
        }


    }


}
