package Distance_Between_Bus_Stops_1184;

public class Solution {


    public static void main(String[] args) {

        System.out.println(distanceBetweenBusStops(new int[]{7,10,1,12,11,14,5,0},7,2));

    }


    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {


        int m1 = 0;
        int m2 = 0;
        boolean m1Over = false;
        boolean m2Over = false;

        int i = start;
        int j = start;

        while (!(m1Over&&m2Over)){
            //System.out.println(i+" "+j);
            if(i==destination){
                m1Over = true;
            }
            if(!m1Over){
                m1+=distance[i];
                i++;
                if(i>=distance.length){
                    i = 0;
                }
            }

            if(j==destination){
                m2Over = true;
            }
            if(!m2Over){

                j--;
                if(j<0){
                    j = distance.length-1;
                }
                m2+=distance[j];
            }

        }


        return Math.min(m1,m2);
    }

}
