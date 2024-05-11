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
        Arrays.sort(workers, Comparator.comparingDouble(a -> a.r));
        //System.out.println(Arrays.toString(workers));
        MinHeap<Worker> selectedWorkers = new MinHeap<>(k);
        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;

        for (int i = 0; i <= k-2; i++) {
            selectedWorkers.insert(workers[i]);
            totalQuality += workers[i].q;
        }

        for (int i = k-1; i < workers.length; i++) {
            Worker worker = workers[i];
            if (selectedWorkers.size >= k) {
                Worker removed = selectedWorkers.remove();
                totalQuality -= removed.q;
            }
            selectedWorkers.insert(worker);
            totalQuality += worker.q;
            //System.out.println("selectedWorkers: " + selectedWorkers);
            if (selectedWorkers.size == k) {
                double cost = totalQuality * worker.r;
                //System.out.println("selectedWorkers: " + selectedWorkers + " cost: " + cost);
                minCost = Math.min(cost, minCost);
            }
        }

        return minCost;
    }

    private static class Worker implements  Comparable<Worker>{
        int w;
        int q;
        double r;
        public Worker(int w, int q) {
            this.w = w;
            this.q = q;
            this.r = 1d*w/q;
        }
        @Override
        public String toString() {
            return "Worker{" +
                    "w=" + w +
                    ", q=" + q +
                    ", r=" + r +
                    '}';
        }

        @Override
        public int compareTo(Worker o) {
            return Integer.compare(o.q, this.q);
        }
    }

    private static class MinHeap<T extends Comparable<T>> {

        private T[] heap;
        private final int CAPACITY;
        private int size;

        @SuppressWarnings("unchecked")
        public MinHeap(int capacity) {
            this.CAPACITY = capacity;
            heap = (T[]) new Comparable[capacity];
        }

        public void insert(T val) {
            if (size < CAPACITY) {
                heap[size] = val;
                int current = size;
                size++;

                while (current != 0 && heap[current].compareTo(heap[getParentIndex(current)]) < 0) {
                    swap(heap, current, getParentIndex(current));
                    current = getParentIndex(current);
                }
            } else {
                throw new RuntimeException("Heap is full");
            }
        }

        public T remove() {
            if (size != 0) {
                return extractMin(heap, size - 1);
            } else {
                throw new RuntimeException("Heap is empty");
            }
        }

        private T extractMin(T[] heap, int n) {
            T min = heap[0];
            heap[0] = heap[n];
            heapify(heap, 0, n - 1);
            size--;
            return min;
        }

        private void heapify(T[] heap, int i, int n) {
            int smallest = i;

            if (getLeftChildIndex(i) <= n && heap[getLeftChildIndex(i)].compareTo(heap[smallest]) < 0) {
                smallest = getLeftChildIndex(i);
            }

            if (getRightChildIndex(i) <= n && heap[getRightChildIndex(i)].compareTo(heap[smallest]) < 0) {
                smallest = getRightChildIndex(i);
            }

            if (smallest != i) {
                swap(heap, i, smallest);
                heapify(heap, smallest, n);
            }
        }

        private int getLeftChildIndex(int index) { return 2 * index + 1; }
        private int getRightChildIndex(int index) { return 2 * index + 2; }
        private int getParentIndex(int index) { return (index - 1) / 2; }

        private void swap(T[] heap, int i1, int i2) {
            T temp = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(heap, size));
        }

        public void printer() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) < size; j++) {
                    System.out.print(heap[j + (int)Math.pow(2, i) - 1] + " ");
                }
                System.out.println();
            }
        }
    }



}
