package Design_a_Stack_With_Increment_Operation_1381;

public class Solution {


    public static void main(String[] args) {

        CustomStack obj = new CustomStack(3);
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.increment(5, 100);
        obj.increment(2, 100);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }

    private static class CustomStack {

        private int lenght;
        private int [] array;
        private int incrementRecord [];

        public CustomStack(int maxSize) {
            array = new int[maxSize];
            incrementRecord = new int[maxSize];
        }

        public void push(int x) {
            if(lenght == array.length) return;
            array[lenght++] = x;
        }

        public int pop() {
            if(lenght == 0) return -1;
            lenght--;
            int val = array[lenght];
            val += incrementRecord[lenght];
            if(lenght != 0){
                incrementRecord[lenght-1] += incrementRecord[lenght];
            }
            incrementRecord[lenght] = 0;
            return val;
        }

        public void increment(int k, int val) {
            if(k>lenght){
                k = lenght;
            }
            k--;
            if(k>=0)
                incrementRecord[k] += val;
        }
    }



}
