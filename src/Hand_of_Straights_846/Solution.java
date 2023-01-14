package Hand_of_Straights_846;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int hand [] = new int[]{1,2,2,3,3,3,4,4,5};

        System.out.println(isNStraightHand(hand,3));

    }


    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        HashMap<Integer,Integer> counter = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < hand.length; i++) {
            if(counter.containsKey(hand[i])){
                counter.put(hand[i],counter.get(hand[i])+1);
            }else{
                counter.put(hand[i],1);
                set.add(hand[i]);
            }
        }

        while (!set.isEmpty()){

            int f = set.first();
            for (int i = 0; i < groupSize; i++) {
                if(set.contains(f+i)){
                    DecreaseElement(set,counter,f+i);
                }
                else
                    return false;
            }

        }


        return true;
    }

    private static void DecreaseElement(TreeSet<Integer> set, HashMap<Integer,Integer> map, int value){

        int remainder = map.get(value)-1;
        if(remainder==0){
            map.remove(value);
            set.remove(value);
        }else{
            map.put(value,remainder);
        }

    }


}
