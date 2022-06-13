package Possible_Bipartition_886;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static boolean possibleBipartition(int N, int[][] dislikes) {

        List<Vertex> vertexs = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            vertexs.add(new Vertex(i));
        }


        for (int i = 0; i < dislikes.length; i++) {

            int a = dislikes[i][0] - 1;
            int b = dislikes[i][1] - 1;

            vertexs.get(a).addEdge(vertexs.get(b));
            vertexs.get(b).addEdge(vertexs.get(a));
        }

        vertexs.get(0).setColor(1);

        boolean again=false;
        int change =0;

        for (int i = 0; i < N; i++) {

            boolean rst = vertexs.get(i).control();
            if(rst==false) return false;

            if(!again&&vertexs.get(i).getColor()==0){
                again = true;
                change = i;

            }

            if(again&&i==N-1){
                again=false;
                if(vertexs.get(change).getColor()==0)
                    vertexs.get(change).setColor(-1);
                i=-1;
            }

        }


        return true;
    }

    protected static class Vertex{


        private int id;

        List<Vertex> edges= new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }



        public void addEdge(Vertex v){
            if(v==null)return;

            if(!edges.contains(v))
                edges.add(v);


        }


        public Vertex goVertex(Vertex v){

            if(edges.contains(v)){
                return v;
            }
            else{
                return this;
            }

        }

        @Override
        public String toString() {
            return id+"";
        }

        private int color=0;

        public void setColor(int color) {
            this.color = color;
        }

        public int getColor() {
            return color;
        }



        public boolean control(){

            for (int i = 0; i < edges.size(); i++) {
                Vertex temp = edges.get(i);

                if(temp.getColor()==0){
                    temp.setColor(this.color*-1);
                }
                else if(temp.getColor()==getColor()){
                    return false;
                }

            }
            return true;
        }



    }

}
