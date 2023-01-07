package Count_Common_Words_With_One_Occurrence_2085;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        System.out.println(countWords(
                new String[]{"leetcode","is","amazing","as","is"},
                new String[]{"amazing","leetcode","is"}

        ));


    }


    enum Status {
        FIRST,
        MULTI,
        FIRST_IN_SECOND,
        MULTI_IN_SECOND
    }

    public static int countWords(String[] words1, String[] words2) {


        HashMap<String, Status> stringBooleanHashMap = new HashMap<>();

        for (int i = 0; i < words1.length; i++) {
            if(stringBooleanHashMap.containsKey(words1[i])){
                stringBooleanHashMap.put(words1[i], Status.MULTI);
            }else{
                stringBooleanHashMap.put(words1[i], Status.FIRST);
            }

        }

        for (int i = 0; i < words2.length; i++) {

            if(stringBooleanHashMap.containsKey(words2[i]) && stringBooleanHashMap.get(words2[i])==Status.FIRST_IN_SECOND){
                stringBooleanHashMap.put(words2[i],Status.MULTI_IN_SECOND);
            }
            else if(stringBooleanHashMap.containsKey(words2[i]) && stringBooleanHashMap.get(words2[i])== Status.FIRST){
                stringBooleanHashMap.put(words2[i],Status.FIRST_IN_SECOND);
            }
        }

        int counter = 0;
        for (Status status: stringBooleanHashMap.values()) {
            if(status == Status.FIRST_IN_SECOND)
                counter++;
        }
        return counter;
    }


}
