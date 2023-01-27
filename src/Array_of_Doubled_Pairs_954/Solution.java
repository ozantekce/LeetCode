package Array_of_Doubled_Pairs_954;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        //System.out.println(canReorderDoubled(new int[]{3,1,3,5}));
        //System.out.println(canReorderDoubled(new int[]{2,1,2,6}));
        System.out.println(canReorderDoubled(new int[]{2,4,0,0,8,1}));
        //System.out.println(canReorderDoubled(new int[]{1,2,4,16,8,4}));
        //System.out.println(canReorderDoubled(new int[]{2,1,2,6}));
        //System.out.println(canReorderDoubled(new int[]{4,2}));
        //System.out.println(canReorderDoubled(new int[]{1,2,4,16,8,4}));

    }


    public static boolean canReorderDoubled(int[] arr) {

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        boolean positiveState = true;
        while (!map.isEmpty()){
            Map.Entry<Integer, Integer> l;
            int key ;
            int value ;
            if(positiveState){
                l = map.pollLastEntry();
                if(l.getKey()<0){
                    positiveState = false;
                    map.put(l.getKey(),l.getValue());
                    continue;
                }
                key = l.getKey();
                value = l.getValue();
                if((key)%2==1){
                    return false;
                }else if(key==0 && value%2==0){
                    continue;
                }

            }else{
                l = map.pollFirstEntry();
                key = l.getKey();
                value = l.getValue();
                if((-key)%2==1){
                    return false;
                }
            }

            int targetKey = key/2;
            if(!map.containsKey(targetKey))
                return false;

            int targetValue = map.get(targetKey);

            targetValue-=value;
            if(targetValue>0)
                map.put(targetKey,targetValue);
            else if(targetValue==0)
                map.remove(targetKey);
            else{
                return false;
            }
        }

        return true;
    }


}
