package Minimum_Fuel_Cost_to_Report_to_the_Capital_2477;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int [][] roads = new int[][]{{}};
        System.out.println(minimumFuelCost(roads,2));


    }

    public static long minimumFuelCost(int[][] roads, int seats) {

        if(roads.length==1){
            return 0;
        }
        Helper [] roadsMap = new Helper[roads.length+1];

        for (int i = 0; i < roads.length+1; i++) {
            roadsMap[i] = new Helper(i);
        }

        for (int i = 0; i < roads.length; i++) {
            int c1 = roads[i][0];
            int c2 = roads[i][1];
            roadsMap[c1].size++;
            roadsMap[c2].size++;
        }
        for (int i = 0; i < roads.length+1; i++) {
            roadsMap[i].configurations();
        }

        for (int i = 0; i < roads.length; i++) {
            int c1 = roads[i][0];
            int c2 = roads[i][1];
            roadsMap[c1].add(c2);
            roadsMap[c2].add(c1);
        }

        //System.out.println(roadsMap);

        TotalCost = 0;
        Seats = seats;
        int c = calculate(roadsMap,0,0);
        removeCost(c,seats);
        TotalCost = Math.max(0,TotalCost);
        return TotalCost;
    }

    private static class Helper{

        private int value;
        private int [] nexts;
        private int size;
        private int current;

        public Helper(int value) {
            this.value = value;
        }

        public void configurations(){
            nexts = new int[size];
        }

        public void add(int v){
            nexts[current] = v;
            current++;
        }

    }

    private static long TotalCost = 0;
    private static int Seats;
    private static int calculate(Helper[] roads,int parent,int current){

        int[] nexts = roads[current].nexts;
        if(nexts.length==1 && current!=0){
            addCost(1,Seats);
            return 1;
        }else{
            int value = 1;
            for (int i = 0; i < nexts.length; i++) {
                if(nexts[i]!=parent){
                    value += calculate(roads,current,nexts[i]);
                }
            }
            addCost(value,Seats);
            return value;
        }


    }

    private static void addCost(int travellers,int maxSeats){
        int n = (travellers + maxSeats - 1) / maxSeats;
        TotalCost += n;
    }

    private static void removeCost(int travellers,int maxSeats){
        int n = (travellers + maxSeats - 1) / maxSeats;
        TotalCost -= n;
    }


}
