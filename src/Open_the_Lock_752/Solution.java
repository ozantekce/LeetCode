package Open_the_Lock_752;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
        System.out.println(openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));

    }


    public static int openLock(String[] deadends, String target) {

        if(target.equals("0000"))
            return 0;

        int i = 0;
        int size = 0;
        int [] frontier = new int[10000];
        int [] added = new int[10000];
        int start = 0;

        int targetInt = convertToInt(target);

        frontier[size++] = start;
        added[start] = -1;

        for (String s : deadends) {
            int deadened = convertToInt(s);
            added[deadened] = -1;
            if (deadened == 0) {
                return -1;
            }
        }

        while (i < size){

            int current = frontier[i++];
            int currentCount = Math.max(added[current], 0);
            if(current == targetInt){
                return currentCount;
            }

            int[] children = findChildren(current);

            for (Integer child : children) {
                if(added[child] == 0){
                    frontier[size++] = child;
                    added[child] = currentCount + 1;
                }
            }
        }

        return -1;
    }

    private static int convertToInt(String str){
        int value = 0;
        value += 1000 * (str.charAt(0) - '0');
        value += 100 * (str.charAt(1) - '0');
        value += 10 * (str.charAt(2) - '0');
        value += (str.charAt(3) - '0');
        return value;
    }


    private static int[] cache = new int[8];
    private static int[] findChildren(int current){

        int mul = 1;
        for (int i = 0; i < 4; i++) {

            int num = (current / mul) % 10;

            int forward = (num + 1) % 10;
            int backward = (num - 1 + 10) % 10;

            int childForward = (current - num * mul) + forward * mul;
            int childBackward = (current - num * mul) + backward * mul;

            cache[2 * i] = childForward;
            cache[2 * i + 1] = (childBackward);

            mul *= 10;
        }

        return cache;
    }



}
