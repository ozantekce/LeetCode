package Kth_Distinct_String_in_an_Array_2053;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(kthDistinct(
                new String[]{"d","b","c","b","c","a"},2

        ));


    }


    public static String kthDistinct(String[] arr, int k) {

        HashMap<String,Integer> stringIntegerHashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if(!stringIntegerHashMap.containsKey(arr[i])){
                stringIntegerHashMap.put(arr[i],i );
            }else{
                stringIntegerHashMap.put(arr[i],-1);
            }
        }

        List<IntStringPair> list = new ArrayList<>();
        for(HashMap.Entry<String, Integer> entry : stringIntegerHashMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if(value!=-1){
                list.add(new IntStringPair(value,key));
            }
        }
        Collections.sort(list);

        if(list.size()<=k){
            return list.get(k-1).str;
        }

        return "";
    }


    private static class IntStringPair implements Comparable<IntStringPair>{

        public int index;
        public String str;

        public IntStringPair(int index, String str) {
            this.index = index;
            this.str = str;
        }

        @Override
        public int compareTo(IntStringPair o) {

            if(this.index>o.index){
                return 1;
            }else if(this.index<o.index){
                return -1;
            }
            else{
                return -1;
            }

        }

    }



}
