package Dota2_Senate_649;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
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
        if(senate.charAt(0) == 'R'){
            queue.add(last = new MyInteger(1));
        }else{
            queue.add(last = new MyInteger(-1));
        }
        for (int i = 1; i < senate.length(); i++) {
            char currentChar = senate.charAt(i);
            int currentValue;
            if(currentChar == 'R'){
                currentValue = 1;
            }else{
                currentValue = -1;
            }

            if(currentValue>0 && last.value>0){
                last.value++;
            }else if(currentValue<0 && last.value<0){
                last.value--;
            }else{
                queue.add(last = new MyInteger(currentValue));
            }
        }

        while (queue.size() > 1){
            MyInteger current = queue.poll();
            int moveCount = Math.abs(current.value);
            while (moveCount > 0 && queue.size() > 0){
                MyInteger next = queue.peek();
                if(current.value > 0 && next.value > 0){
                    current.value += next.value;
                    moveCount += Math.abs(next.value);
                    queue.poll();
                }else if(current.value < 0 && next.value < 0){
                    current.value += next.value;
                    moveCount += Math.abs(next.value);
                    queue.poll();
                }else{
                    int nextCount = Math.abs(next.value);
                    if(moveCount >= nextCount){
                        moveCount -= nextCount;
                        queue.poll();
                    }else{
                        nextCount -= moveCount;
                        next.value = nextCount * (next.value > 0 ? 1 : -1);
                        break;
                    }
                }
            }
            queue.add(current);
        }


        return queue.poll().value > 0 ? "Radiant":"Dire";
    }

    private static class MyInteger{
        int value;

        public MyInteger(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return ""+ value;
        }
    }


}
