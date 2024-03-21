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
        for (int i = 0; i < coordinates.size(); i++) {

            int x1 = coordinates.get(i).get(0);
            int y1 = coordinates.get(i).get(1);

            if(!Counter.isEmpty()){
                for (int j = 0; j <= k; j++) {
                    int x = j;
                    if(k - x < 0){
                        break;
                    }
                    int x2 = (x ^ x1);
                    int y2 = (k - x) ^ y1;

                    if(Counter.containsKey(x2)){
                        HashMap<Integer,Integer> temp = Counter.get(x2);
                        int coordinateCount = temp.getOrDefault(y2, 0);
                        count += coordinateCount;
                    }

                }
            }
            
            HashMap<Integer,Integer> temp = Counter.getOrDefault(x1, new HashMap<>());
            int coordinateCount = temp.getOrDefault(y1, 0) + 1;
            temp.put(y1, coordinateCount);
            Counter.put(x1, temp);

        }
        return count;
    }


}
