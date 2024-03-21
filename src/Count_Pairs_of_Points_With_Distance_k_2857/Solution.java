package Count_Pairs_of_Points_With_Distance_k_2857;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        List<List<Integer>> coordinates0 = new ArrayList<>();
        coordinates0.add(Arrays.asList(1, 2));
        coordinates0.add(Arrays.asList(4, 2));
        coordinates0.add(Arrays.asList(1, 3));
        coordinates0.add(Arrays.asList(5, 2));

        System.out.println(countPairs(coordinates0, 5));

        List<List<Integer>> coordinates1 = new ArrayList<>();
        coordinates1.add(Arrays.asList(27, 94));
        coordinates1.add(Arrays.asList(61, 68));
        coordinates1.add(Arrays.asList(47, 0));
        coordinates1.add(Arrays.asList(100, 4));
        coordinates1.add(Arrays.asList(127, 89));
        coordinates1.add(Arrays.asList(61, 103));
        coordinates1.add(Arrays.asList(26, 4));
        coordinates1.add(Arrays.asList(51, 54));
        coordinates1.add(Arrays.asList(91, 26));
        coordinates1.add(Arrays.asList(98, 23));
        coordinates1.add(Arrays.asList(80, 74));
        coordinates1.add(Arrays.asList(19, 93));

        System.out.println(countPairs(coordinates1, 95));

    }


    private static final HashMap<Integer,HashMap<Integer,Integer>> Counter = new HashMap<>();

    public static int countPairs(List<List<Integer>> coordinates, int k) {

        int count = 0;
        Counter.clear();

        int x1 = coordinates.get(0).get(0);
        int y1 = coordinates.get(0).get(1);
        HashMap<Integer,Integer> subCounter = Counter.getOrDefault(x1, new HashMap<>());
        int coordinateCount = subCounter.getOrDefault(y1, 0) + 1;
        subCounter.put(y1, coordinateCount);
        Counter.put(x1, subCounter);

        for (int i = 1; i < coordinates.size(); i++) {

            x1 = coordinates.get(i).get(0);
            y1 = coordinates.get(i).get(1);

            for (int x = 0; x <= k; x++) {
                int x2 = (x ^ x1);
                if(Counter.containsKey(x2)){
                    int y2 = (k - x) ^ y1;
                    subCounter = Counter.get(x2);
                    count += subCounter.getOrDefault(y2, 0);
                }
            }

            subCounter = Counter.getOrDefault(x1, new HashMap<>());
            coordinateCount = subCounter.getOrDefault(y1, 0) + 1;
            subCounter.put(y1, coordinateCount);
            Counter.put(x1, subCounter);

        }
        return count;
    }

}
