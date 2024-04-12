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

        Queue<MyInteger> queue = new ArrayDeque<>();
        MyInteger last;
        queue.add(last = new MyInteger(1, senate.charAt(0) == 'R'));
        for (int i = 1; i < senate.length(); i++) {
            boolean isR = senate.charAt(i) == 'R';
            if(isR == last.party){
                last.value++;
            }else{
                queue.add(last = new MyInteger(1, isR));
            }
        }

        while (queue.size() > 1){
            MyInteger current = queue.poll();
            int moveCount = current.value;
            while (moveCount > 0 && queue.size() > 0){
                MyInteger next = queue.peek();
                if(current.party == next.party){
                    // Merge
                    current.value += next.value;
                    moveCount += next.value;
                    queue.poll();
                }else{
                    // Ban
                    int nextCount = next.value;
                    if(moveCount >= nextCount){
                        moveCount -= nextCount;
                        queue.poll();
                    }else{
                        nextCount -= moveCount;
                        next.value = nextCount;
                        break;
                    }
                }
            }
            queue.add(current);
        }


        return queue.poll().party ? "Radiant":"Dire";
    }

    private static class MyInteger{

        private int value;
        private boolean party;

        public MyInteger(int value, boolean party) {
            this.value = value;
            this.party = party;
        }


        @Override
        public String toString() {
            return ""+ value;
        }
    }


}
