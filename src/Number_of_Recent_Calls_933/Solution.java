package Number_of_Recent_Calls_933;

public class Solution {


    public static void main(String[] args) {

        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));

    }

    static class RecentCounter {

        private int[] data;
        private final int capacity;
        private int headIndex = 0;  // Next index to write
        private int tailIndex = 0;  // Next index to read
        private int size = 0;


        public RecentCounter() {
            this.capacity = 3001;
            data = new int[this.capacity];
        }

        public int ping(int t) {

            if(size == capacity){
                dequeue();
            }

            int min = Math.max(t - 3000, 0);
            enqueue(t);

            while (true){
                int val = peek();
                if(val < min){
                    dequeue();
                }else{
                    break;
                }
            }
            return size;
        }


        public void enqueue(int element) {
            data[headIndex] = element;
            headIndex = (headIndex + 1) % capacity;
            size++;
        }

        public int dequeue() {
            int element = data[tailIndex];
            data[tailIndex] = -1;
            tailIndex = (tailIndex + 1) % capacity;
            size--;
            return element;
        }

        public int peek() {
            return data[tailIndex];
        }



    }


}
