package K_th_Smallest_Prime_Fraction_786;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1,2,3,5,7,23}, 3)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1,13,17,59}, 6)));
        //System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 7}, 1)));

    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        return heapSolution(arr, k);
    }

    private static int[] heapSolution(int[] arr, int k){
        int n = arr.length-1;
        if(k == 1){
            return new int[]{arr[0], arr[n]};
        }
        boolean[][] added = new boolean[1001][1001];
        MinHeap<Int2> pointers = new MinHeap<>((arr.length * (arr.length-1)) / 4);
        pointers.insert(new Int2(0, n, 1d*arr[0]/arr[n]));
        int counter = 0;
        while (true){
            Int2 selected;
            selected = pointers.remove();
            int childI = selected.i + 1;
            int childJ = selected.j - 1;
            if(childI <= n && !added[childI][selected.j] && childI < selected.j){
                Int2 child = new Int2(childI, selected.j, 1d * arr[childI] / arr[selected.j]);
                pointers.insert(child);
                added[childI][selected.j] = true;
            }
            if(childJ >= 0 && !added[selected.i][childJ] && selected.i < childJ){
                Int2 child = new Int2(selected.i, childJ, 1d * arr[selected.i] / arr[childJ]);
                pointers.insert(child);
                added[selected.i][childJ] = true;
            }
            counter++;
            if(counter == k){
                return new int[]{arr[selected.i], arr[selected.j]};
            }
        }

    }


    private static class Int2 implements Comparable<Int2>{


        int i, j;
        double v;

        public Int2(int i, int j, double val) {
            this.i = i;
            this.j = j;
            this.v = val;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Int2 int2 = (Int2) o;
            return i == int2.i && j == int2.j;
        }

        @Override
        public int hashCode() {
            return i+j;
        }

        @Override
        public String toString() {
            return "Int2{" +
                    "i=" + i +
                    ", j=" + j +
                    ", v=" + v +
                    '}';
        }

        @Override
        public int compareTo(Int2 other) {
            return Double.compare(this.v, other.v);
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
