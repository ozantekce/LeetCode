package Minimum_Cost_to_Hire_K_Workers_857;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(mincostToHireWorkers(new int[]{10,20,5}, new int[]{70,50,30}, 2));
        System.out.println("----------------------------------------------------------------------");
        System.out.println(mincostToHireWorkers(new int[]{3,1,10,10,1}, new int[]{4,8,2,2,7}, 3));
        System.out.println("----------------------------------------------------------------------");
        System.out.println(mincostToHireWorkers(new int[]{2}, new int[]{14}, 1));
        System.out.println("----------------------------------------------------------------------");
        System.out.println(mincostToHireWorkers(new int[]{3,4,3}, new int[]{13,8,20}, 1));
        System.out.println("----------------------------------------------------------------------");
        System.out.println(mincostToHireWorkers(new int[]{2,1,5}, new int[]{17,6,4}, 2));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(wage[i], quality[i]);
        }
        Arrays.sort(workers, Comparator.comparingDouble(Worker::getRate));
        System.out.println(Arrays.toString(workers));

        PriorityQueue<Worker> selectedWorkers = new PriorityQueue<>((a, b) -> Integer.compare(b.q, a.q));
        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;

        for (int i = 0; i < workers.length; i++) {
            Worker worker = workers[i];
            if (selectedWorkers.size() >= k) {
                Worker removed = selectedWorkers.poll();
                totalQuality -= removed.q;
            }

            selectedWorkers.add(worker);
            totalQuality += worker.q;
            //System.out.println("selectedWorkers: " + selectedWorkers);
            if (selectedWorkers.size() == k) {
                double cost = totalQuality * worker.getRate();
                //System.out.println("selectedWorkers: " + selectedWorkers + " cost: " + cost);
                minCost = Math.min(cost, minCost);
            }
        }

        return minCost;
    }


    private static class Worker{

        int w;
        int q;
        double r;

        public Worker(int w, int q) {
            this.w = w;
            this.q = q;
            this.r = 1d*w/q;
        }

        double getRate(){
            return r;
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "w=" + w +
                    ", q=" + q +
                    ", r=" + getRate() +
                    '}';
        }
    }

    
}
