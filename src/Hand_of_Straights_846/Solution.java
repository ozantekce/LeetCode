package Hand_of_Straights_846;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int hand [] = new int[]{1,2,2,3,3,3,4,4,5};
        int hand1 [] = new int[]{9,13,15,23,22,25,4,4,29,15,8,23,12,19,24,17,18,11,22,24,17,17,10,23,21,18,14,18,7,6,3,6,19,11,16,11,12,13,8,26,17,20,13,19,22,21,27,9,20,15,20,27,8,13,25,23,22,15,9,14,20,10,6,5,14,12,7,16,21,18,21,24,23,10,21,16,18,16,18,5,20,19,20,10,14,26,2,9,19,12,28,17,5,7,25,22,16,17,21,11};

        System.out.println(isNStraightHand(hand,3));
        System.out.println(isNStraightHand(hand1,10));

    }


    public static boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0){
            return false;
        }

        Arrays.sort(hand);

        HashMap<Integer,Integer> counter = new HashMap<>();
        List<Integer> sortedSet = new ArrayList<>();

        for (int i = 0; i < hand.length; i++) {
            if(counter.containsKey(hand[i])){
                counter.put(hand[i], counter.get(hand[i])+1);
            }else{
                counter.put(hand[i], 1);
                sortedSet.add(hand[i]);
            }
        }

        for (int i = 0; i < sortedSet.size();) {
            int firstValue = sortedSet.get(i);
            for (int j = 0; j < groupSize; j++) {
                int nextValue = firstValue + j;
                if(!counter.containsKey(nextValue)){
                    return false;
                }
                int remainder = counter.get(nextValue) - 1;
                if(remainder < 0){
                    return false;
                }
                else{
                    counter.put(nextValue,remainder);
                    if(remainder == 0)
                        i++;
                }
            }
        }

        return true;
    }




}
