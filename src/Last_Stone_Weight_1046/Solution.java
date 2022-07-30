package Last_Stone_Weight_1046;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        int[] stones = {2,7,4,1,8,1};

        System.out.println(lastStoneWeight(stones));

    }

    public static int lastStoneWeight(int[] stones) {

        int size = stones.length;
        while (true){
            if(size==1){
                return stones[0];
            }else if(size==0){
                return 0;
            }
            Arrays.sort(stones);
            int stone1 = stones[size-1];
            int stone2 = stones[size-2];
            size -= 2;
            if(stone1>stone2){
                stone1 -= stone2;
                size++;
                stones[size-1] = stone1;
            }else if(stone1<stone2){
                stone2 -= stone1;
                size++;
                stones[size-1] = stone2;
            }

        }

    }


}
