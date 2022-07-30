package Last_Stone_Weight_1046;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        int[] stones = {2,7,4,1,8,1};

        System.out.println(lastStoneWeight(stones));

    }

    public static int lastStoneWeight(int[] stones) {

        List<Integer> stoneList = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            stoneList.add(stones[i]);
        }
        while (true){
            if(stoneList.size()==1){
                return stoneList.get(0);
            }else if(stoneList.size()==0){
                return 0;
            }
            Collections.sort(stoneList);
            int stone1 = stoneList.remove(stoneList.size()-1);
            int stone2 = stoneList.remove(stoneList.size()-1);
            if(stone1>stone2){
                stone1 -= stone2;
                stoneList.add(stone1);
            }else if(stone1<stone2){
                stone2 -= stone1;
                stoneList.add(stone2);
            }

        }

    }


}
