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
        coordinates1.add(Arrays.asList(1, 3));
        coordinates1.add(Arrays.asList(1, 3));
        coordinates1.add(Arrays.asList(1, 3));
        coordinates1.add(Arrays.asList(1, 3));
        coordinates1.add(Arrays.asList(1, 3));

        //System.out.println(countPairs(coordinates1, 0));

    }

    private static HashSet<Integer> Xs = new HashSet<>();
    private static HashSet<Integer> Ys = new HashSet<>();
    private static final HashMap<Integer,HashMap<Integer,Integer>> NeedTable = new HashMap<>();

    public static int countPairs(List<List<Integer>> coordinates, int k) {

        Xs.clear();
        Ys.clear();
        for (int i = 0; i < coordinates.size(); i++) {
            int x1 = coordinates.get(i).get(0);
            int y1 = coordinates.get(i).get(1);
            Xs.add(x1);
            Ys.add(y1);
        }

        int count = 0;
        NeedTable.clear();
        for (int i = 0; i < coordinates.size(); i++) {

            int x1 = coordinates.get(i).get(0);
            int y1 = coordinates.get(i).get(1);

            if(NeedTable.containsKey(x1) && NeedTable.get(x1).containsKey(y1)){
                count += NeedTable.get(x1).get(y1);
            }

            for (int j = 0; j <= k; j++) {
                int x = j;
                if(k - x < 0){
                    break;
                }
                int x2 = (x ^ x1);
                int y2 = (k - x) ^ y1;

                if(!Xs.contains(x2) || !Ys.contains(y2)){
                    continue;
                }

                //System.out.println("x2 : "+ x2 +" y2 : "+ y2);

                HashMap<Integer,Integer> temp = NeedTable.getOrDefault(x2, new HashMap<>());
                int needCount = temp.getOrDefault(y2, 0) + 1;
                temp.put(y2, needCount);
                NeedTable.put(x2, temp);
            }

        }
        return count;
    }






}
