package Take_Gifts_From_the_Richest_Pile_2558;

public class Solution {

    public static void main(String[] args) {


        System.out.println(pickGifts(new int[]{25,64,9,4,100}, 4));

    }

    public static long pickGifts(int[] gifts, int k) {

        long result = 0;
        MaxHeap pq = new MaxHeap(gifts.length);

        for (int gift : gifts) {
            pq.insert(gift);
        }

        for (int i = 0; i < k; i++) {
            pq.insert((int) Math.sqrt(pq.remove()));
        }

        while (!pq.isEmpty()){
            result += pq.remove();
        }

        return result;
    }

    private static class MaxHeap {

        private int[] heap;
        private final int capacity;
        private int size;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
        }

        public void insert(int val) {
            if (size == capacity) {
                throw new IllegalStateException("Heap is full");
            }
            heap[size] = val;
            int current = size;
            size++;
            while (heap[current] > heap[getParentIndex(current)]) {
                swap(heap, current, getParentIndex(current));
                current = getParentIndex(current);
            }
        }

        public int remove() {
            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }
            return extractMax();
        }

        private int extractMax() {
            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapify(0);
            return max;
        }

        private void heapify(int i) {
            int largest = i;
            int leftChildIdx = getLeftChildIndex(i);
            int rightChildIdx = getRightChildIndex(i);

            if (leftChildIdx < size && heap[leftChildIdx] > heap[largest]) {
                largest = leftChildIdx;
            }

            if (rightChildIdx < size && heap[rightChildIdx] > heap[largest]) {
                largest = rightChildIdx;
            }

            if (largest != i) {
                swap(heap, i, largest);
                heapify(largest);
            }
        }

        private int getLeftChildIndex(int index) {
            return 2 * index + 1;
        }

        private int getRightChildIndex(int index) {
            return 2 * index + 2;
        }

        private int getParentIndex(int index) {
            return (index - 1) / 2;
        }

        private void swap(int[] heap, int i1, int i2) {
            int temp = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }


}
