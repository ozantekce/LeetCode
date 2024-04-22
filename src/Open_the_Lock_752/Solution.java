package Open_the_Lock_752;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
        System.out.println(openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));

    }


    public static int openLock(String[] deadends, String target) {

        if(target.equals("0000"))
            return 0;

        Queue<Integer> frontier = new ArrayDeque<>();
        int [] added = new int[10000];
        int start = 0;

        int targetInt = 0;
        targetInt += 1000 * (target.charAt(0) - '0');
        targetInt += 100 * (target.charAt(1) - '0');
        targetInt += 10 * (target.charAt(2) - '0');
        targetInt += (target.charAt(3) - '0');

        frontier.add(start);
        added[start] = -1;

        for (int i = 0; i < deadends.length; i++) {
            int deadend = 0;
            deadend += 1000 * (deadends[i].charAt(0) - '0');
            deadend += 100 * (deadends[i].charAt(1) - '0');
            deadend += 10 * (deadends[i].charAt(2) - '0');
            deadend += (deadends[i].charAt(3) - '0');
            added[deadend] = -1;
            if(deadend == 0){
                return -1;
            }
        }

        while (!frontier.isEmpty()){

            int current = frontier.poll();
            int currentCount = Math.max(added[current], 0);
            if(current == targetInt){
                return currentCount;
            }

            List<Integer> children = findChildren(current);

            for (Integer child : children) {
                if(added[child] == 0){
                    frontier.add(child);
                    added[child] = currentCount + 1;
                }
            }
        }

        return -1;
    }

    


    private static List<Integer> cacheList = new ArrayList<>(8);
    private static List<Integer> findChildren(int current){

        cacheList.clear();
        int mul = 1;
        for (int i = 0; i < 4; i++) {

            int num = current / mul;
            num %= 10;

            int forward = num + 1;
            int backward = num - 1;

            if(forward > 9){
                forward = 0;
            }

            int childForward = current;
            childForward -= num * mul;
            childForward += forward * mul;

            if(backward < 0){
                backward = 9;
            }

            int childBackward = current;
            childBackward -= num * mul;
            childBackward += backward * mul;

            cacheList.add(childForward);
            cacheList.add(childBackward);

            mul *= 10;
        }

        return cacheList;
    }



}
