package Dota2_Senate_649;


import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        System.out.println("Res: "+predictPartyVictory("RD")+" | Radian");
        System.out.println("Res: "+predictPartyVictory("RDD")+" | Dire");
        System.out.println("Res: "+predictPartyVictory("DDRRR")+" | Dire");
        System.out.println("Res: "+predictPartyVictory("DRRD")+" | Dire");
        System.out.println("Res: "+predictPartyVictory("DRRDRDRDRDDRDRDR")+" | Radian");

    }


    public static String predictPartyVictory(String senate) {

        Queue<ValuePartyPair> queue = new ArrayDeque<>(senate.length());
        ValuePartyPair last;
        queue.add(last = new ValuePartyPair(1, senate.charAt(0) == 'R'));
        // Merge elements
        for (int i = 1; i < senate.length(); i++) {
            boolean isR = senate.charAt(i) == 'R';
            if(isR == last.party){
                // merge with last
                last.value++;
            }else{
                // create new
                queue.add(last = new ValuePartyPair(1, isR));
            }
        }

        ValuePartyPair current = queue.poll();
        int moveCount = current.value;
        while (queue.size() > 0){
            ValuePartyPair next = queue.peek();
            if(current.party == next.party){
                // Merge
                current.value += next.value;    // increase current value
                moveCount += next.value;    // increase move count
                queue.poll();   // remove merged element
            }else{
                // Ban
                int nextCount = next.value;
                // It can remove next completely
                if(moveCount > nextCount){
                    moveCount -= nextCount; // lost move count
                    queue.poll();   // remove next
                }
                // It cannot remove next completely
                else{
                    // It removes as much as it can
                    next.value -= moveCount;
                    // Re add current
                    queue.add(current);
                    // Update current with next
                    current = queue.poll();
                    moveCount = current.value;
                }
            }
        }

        return current.party ? "Radiant":"Dire";
    }

    private static class ValuePartyPair {

        private int value;
        private boolean party;
        public ValuePartyPair(int value, boolean party) {
            this.value = value;
            this.party = party;
        }
    }




}
