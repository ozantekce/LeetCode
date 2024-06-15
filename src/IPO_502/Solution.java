package IPO_502;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {


    public static void main(String[] args) {

        System.out.println(findMaximizedCapital(2,0,new int[]{1,2,3}, new int[]{0,1,1}));
        System.out.println(findMaximizedCapital(3,0,new int[]{1,2,3}, new int[]{0,1,2}));

    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Pair[] minCapitalArray = new Pair[profits.length];
        PriorityQueue<Pair> maxProfitHeap = new PriorityQueue<>(profits.length, (a, b) -> b.profit - a.profit);

        for (int i = 0; i < profits.length; i++) {
            minCapitalArray[i] = new Pair(capital[i], profits[i]);
        }
        Arrays.sort(minCapitalArray, (a, b) -> a.capital - b.capital);

        int indexOfMinCapitalArray = 0;

        for (int i = 0; i < k; i++) {
            while (indexOfMinCapitalArray < minCapitalArray.length &&
                    minCapitalArray[indexOfMinCapitalArray].capital <= w) {
                maxProfitHeap.add(minCapitalArray[indexOfMinCapitalArray++]);
            }
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            w += maxProfitHeap.poll().profit;
        }

        return w;
    }

    private static class Pair {
        public int capital;
        public int profit;

        public Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

}
